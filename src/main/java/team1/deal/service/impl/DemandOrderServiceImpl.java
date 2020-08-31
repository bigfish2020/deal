package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import team1.deal.dao.DemandOrderDao;
import team1.deal.mapper.UserMapper;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.DemandOrderBriefInfoVO;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.QuotedPriceInfoVO;
import team1.deal.service.DemandOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
@Service
public class DemandOrderServiceImpl extends ServiceImpl<DemandOrderMapper, DemandOrderPO> implements DemandOrderService {

    @Autowired
    private DemandOrderDao demandOrderDao;

    @Autowired
    private DemandOrderMapper demandOrderMapper;

    @Autowired
    private UserMapper userMapper;

    //订单列表分页
    @Override
    public Page<DemandOrderBriefInfoVO> getDemandOrderByPage(PageParamDTO pageParamDTO){
        Page<DemandOrderPO> page = new Page<>(pageParamDTO.getPageOn(),pageParamDTO.getPageSize());
        LambdaQueryWrapper<DemandOrderPO> queryWrapper = new LambdaQueryWrapper<DemandOrderPO>()
                .eq(DemandOrderPO::getStatus, 4);
        page = demandOrderMapper.selectPage(page,queryWrapper);
        List<DemandOrderPO> list = page.getRecords();
        List<DemandOrderBriefInfoVO> voList = new ArrayList<>();
        for (DemandOrderPO d:list) {
            DemandOrderBriefInfoVO demandOrderBriefInfoVO = new DemandOrderBriefInfoVO();
            BeanUtils.copyProperties(d, demandOrderBriefInfoVO);
            voList.add(demandOrderBriefInfoVO);
        }
        return new Page<DemandOrderBriefInfoVO>().setRecords(voList).setTotal(page.getTotal());
    }

    //根据订单获取所有报价
    @Override
    public List<QuotedPriceInfoVO> getQuotedPriceInfoList(Integer id){
        List<QuotedPriceInfoPO> list = demandOrderDao.getQuotedPriceInfoList(id);
        List<QuotedPriceInfoVO> voList = new ArrayList<>();
        list.forEach(s->{
            QuotedPriceInfoVO quotedPriceInfoVO = new QuotedPriceInfoVO();
            BeanUtils.copyProperties(s,quotedPriceInfoVO);
            quotedPriceInfoVO.setName(userMapper.selectById(s.getUId()).getName());
            quotedPriceInfoVO.setType("临时供应商");
            voList.add(quotedPriceInfoVO);
        });
        return voList;
    }

    //根据采购订单id返回采购订单信息
     public DemandOrderInfoVO getDemandOrderById (Integer id){
         DemandOrderPO demandOrderPO = demandOrderMapper.selectById(id);
         DemandOrderInfoVO demandOrderInfoVO = new DemandOrderInfoVO();
         BeanUtils.copyProperties(demandOrderPO, demandOrderInfoVO);
         //设置订单申请人
         demandOrderInfoVO.setName(userMapper.selectById(demandOrderPO.getUId()).getName());
         demandOrderInfoVO.setReceiptNumber(demandOrderInfoVO.getApplyUnit()+"-"+ demandOrderInfoVO.getApplyTime().toLocalDate());
         return demandOrderInfoVO;
    }
}
