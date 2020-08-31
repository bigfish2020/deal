package team1.deal.service;

import team1.deal.model.dto.DispatchDestinationDTO;
import team1.deal.model.vo.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface DataAnalysisService {
    //阳光用户数量统计
    long getSunUserNumber();

    //需求订单数量统计
    public long getContDemand();

    //采购数量总量统计
    public long contDemandProcurement();

    //近十天交易额占比
    public BigDecimal totalvolume();

    //折线图,各种煤的总量统计
    public List<CoalYearNameGdpVO> aggregateOfAllKindsOfCoal();

    //运输方式统计
    public List<TransportInformationVO> modeOfTransportStatistics();

    //地区煤炭分布统计
    public List<CoalInformationVO> regionalCoalDistribution();

    //关注程度统计
    public List<RadarMapVO> attention();

    //煤炭流向统计
    public List<Map<String,String>> coalFlowStatistics();

    //煤炭发货地
    public List<Map<String, BigDecimal>> coalDeliveryPlace();

    //本周新增需求订单
    long increaseOfDemand();

    //本周新增采购数量
    long increaseOfDemandProcurement();

    //最近新增阳光用户时间
    LocalDateTime getInsertRecentTime();

}