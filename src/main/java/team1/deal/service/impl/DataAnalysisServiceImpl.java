package team1.deal.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.dao.QuotedPriceInfoDao;
import team1.deal.mapper.CityMapper;
import team1.deal.model.dto.DispatchDestinationDTO;
import team1.deal.model.dto.LatitudeAndIongitudeAndNumberDTO;
import team1.deal.model.po.CityPO;
import team1.deal.model.vo.*;
import team1.deal.service.DataAnalysisService;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {

    @Autowired
    private DataAnalysisDao dataAnalysisDao;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private QuotedPriceInfoDao quotedPriceInfoDao;

    //阳光用户数量统计
    public long getSunUserNumber() {
        return dataAnalysisDao.countSunUserNumber();
    }

    //需求订单数量统计
    @Override
    public long getContDemand() {
        return dataAnalysisDao.countDemandNumber();
    }

    //所有需求订单采购数量总量统计
    @Transactional
    @Override
    public long contDemandProcurement() {
        if (dataAnalysisDao.countDemandNumber()!=0){
            return dataAnalysisDao.countDemandProcurement();
        }
        return 0;
    }

    //近十天交易额占比
    @Transactional
    @Override
    public BigDecimal totalvolume() {
        return new BigDecimal(Convert.toStr(dataAnalysisDao.proportion())).setScale(4,BigDecimal.ROUND_HALF_UP);
    }

    //折线图,各种煤的总量统计
    @Transactional
    @Override
    public List<CoalYearNameGdpVO> aggregateOfAllKindsOfCoal() {
        return dataAnalysisDao.kindsOfCoal();
    }

    //运输方式统计
    @Transactional
    @Override
    public List<TransportInformationVO> modeOfTransportStatistics() {
        return dataAnalysisDao.modeOfTransportStatistics();
    }

    //地区煤炭分布统计
    @Transactional
    @Override
    public List<CoalInformationVO> regionalCoalDistribution() {
        return dataAnalysisDao.CoalDistribution();
    }

    //雷达图
    @Transactional
    @Override
    public List<RadarMapVO> attention() {
        return dataAnalysisDao.attention();
    }

    //煤炭流向统计
    @Override
    public List<Map<String,String>> coalFlowStatistics() {
        List<DispatchDestinationDTO> list = dataAnalysisDao.getDispatchDestinationDTO();
        List<Map<String,String>> fromTo = new ArrayList<>();
        list.forEach(s->{
            CityPO cityFrom = cityMapper.selectOne(Wrappers.lambdaQuery(CityPO.class).eq(CityPO::getCityName,s.getPort()));
            CityPO cityTo = cityMapper.selectOne(Wrappers.lambdaQuery(CityPO.class).eq(CityPO::getCityName,s.getDeliveryPlace()));
            Map<String,String> map = new HashMap<>();
            map.put("from",cityFrom.toString());
            map.put("to",cityTo.toString());
            fromTo.add(map);
        });
        return fromTo;
    }

    @Override
    public List<Map<String,BigDecimal>> coalDeliveryPlace(){
        List<CityPO> list = quotedPriceInfoDao.getDeliveryPlace();
        List<Map<String,BigDecimal>> deliveryPlace = new ArrayList<>();
        list.forEach(s->{
            Map<String,BigDecimal> map = new HashMap<>();
            map.put("lng",s.getLongitude());
            map.put("lat",s.getLatitude());
            deliveryPlace.add(map);
        });
        return deliveryPlace;
    }

    @Override
    public long increaseOfDemand(){
        LocalDate now = LocalDate.now();
        // 求这个日期的周一、周日
        LocalDate monday = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        LocalDate sunday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
        return dataAnalysisDao.increaseOfDemand(monday,sunday);
    }

    @Override
    public long increaseOfDemandProcurement(){
        LocalDate now = LocalDate.now();
        // 求这个日期的周一、周日
        LocalDate monday = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        LocalDate sunday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);
        return dataAnalysisDao.increaseOfDemandProcurement(monday,sunday);
    }

    @Override
    public LocalDateTime getInsertRecentTime(){
        return dataAnalysisDao.selectRecentTime();
    }
}
