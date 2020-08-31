package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import team1.deal.dao.QuotedPriceInfoDao;
import team1.deal.dao.UserDao;
import team1.deal.mapper.UserMapper;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;
import team1.deal.model.vo.QuotedPriceInfoVO;
import team1.deal.service.QuotedPriceInfoService;
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
public class QuotedPriceInfoServiceImpl extends ServiceImpl<QuotedPriceInfoMapper, QuotedPriceInfoPO> implements QuotedPriceInfoService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;

    @Autowired
    private QuotedPriceInfoDao quotedPriceInfoDao;

    //得到报价列表
    public IPage<QuotedPriceBriefInfoVO> getQuotedBriefList(PageParamDTO pageParamDTO,Integer userId){
        Page<QuotedPriceBriefInfoVO> page =new Page<>(pageParamDTO.getPageOn(),pageParamDTO.getPageSize());
        //获取用户所拥有的权限id
        List<String> authorityList = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityList.add(s.getAuthority());
        });
        //阳光用户返回所有用户自己提交的报价
        if (authorityList.contains("报价")){
            return quotedPriceInfoDao.getQuotedPriceBriefInfo(page,userId,null);
        }
        //电厂审批用户返回所有已通过的报价
        if (authorityList.contains("审批")){
            return quotedPriceInfoDao.getQuotedPriceBriefInfo(page,null,3);
        }
        return null;
    }

    //根据报价订单返回需求订单
    public DemandOrderInfoVO getDemandOrder(Integer quotedId){
        DemandOrderPO demandOrderPO =quotedPriceInfoDao.getDemandOrder(quotedId);
        DemandOrderInfoVO demandOrderInfoVO = new DemandOrderInfoVO();
        BeanUtils.copyProperties(demandOrderPO, demandOrderInfoVO);
        //设置订单申请人
        demandOrderInfoVO.setName(userMapper.selectById(demandOrderPO.getUId()).getName());
        demandOrderInfoVO.setReceiptNumber(demandOrderInfoVO.getApplyUnit()+"-"+ demandOrderInfoVO.getApplyTime().toLocalDate());
        return demandOrderInfoVO;
    }

    public QuotedPriceInfoVO getQuotedInfoVO(Integer quotedId){
        QuotedPriceInfoVO quotedPriceInfoVO = new QuotedPriceInfoVO();
        QuotedPriceInfoPO quotedPriceInfoPO =quotedPriceInfoMapper.selectById(quotedId);
        BeanUtils.copyProperties(quotedPriceInfoPO,quotedPriceInfoVO);
        quotedPriceInfoVO.setName(userMapper.selectById(quotedPriceInfoPO.getUId()).getName());
        quotedPriceInfoVO.setType("临时供应商");
        return quotedPriceInfoVO;
    }
}
