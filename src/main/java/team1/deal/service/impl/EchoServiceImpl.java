package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.dao.ContractDao;
import team1.deal.dao.DemandOrderDao;
import team1.deal.dao.QuotedPriceInfoDao;
import team1.deal.dao.UserDao;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.mapper.SaveDemandOrderMapper;
import team1.deal.mapper.SaveQuotedPriceInfoMapper;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.ContractPO;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.vo.ContractBriefVO;
import team1.deal.model.vo.DemandOrderBriefInfoVO;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;
import team1.deal.service.ContractService;
import team1.deal.service.EchoService;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class EchoServiceImpl implements EchoService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DemandOrderDao demandOrderDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private SaveDemandOrderMapper saveDemandOrderMapper;
    @Autowired
    private SaveQuotedPriceInfoMapper saveQuotedPriceInfoMapper;


    //获取需求订单简要信息
    public IPage<DemandOrderBriefInfoVO> getDemandOrderBriefInfo(PageParamDTO pageParamDTO, Integer userId){
        Page<DemandOrderBriefInfoVO> page =new Page<>(pageParamDTO.getPageOn(),pageParamDTO.getPageSize());
        //获取用户所拥有的权限id
        List<String> authorityList = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityList.add(s.getAuthority());
        });
        //接下来根据部门和权限做出相应的回应
        //阳光用户返回所有能报价的订单
        if (authorityList.contains("报价")){
            return demandOrderDao.getDemandOrderBriefInfo(page,null,4,LocalDateTime.now());
        }
        //获取用户所在部门
        String dept = userDao.getUserDept(userId).getDeptName();
        if (authorityList.contains("提出需求")&&dept.equals("电厂")){
            return demandOrderDao.getDemandOrderBriefInfo(page,userId,null,null);
        }else if (authorityList.contains("审核")&&dept.equals("电厂")){
            return demandOrderDao.getDemandOrderBriefInfo(page,null,0,null);
        }else if (authorityList.contains("审批")&&dept.equals("电厂")){
            return demandOrderDao.getDemandOrderBriefInfo(page,null,1,null);
        }else if (authorityList.contains("审核")&&dept.equals("子公司")){
            return demandOrderDao.getDemandOrderBriefInfo(page,null,2,null);
        }else if (authorityList.contains("审批")&&dept.equals("子公司")){
            return demandOrderDao.getDemandOrderBriefInfo(page,null,3,null);
        }
        return null;
    }

    //报价时获取需求订单简要信息
    public IPage<DemandOrderBriefInfoVO> getDemandOrderBriefInfoQuoted(PageParamDTO pageParamDTO, Integer userId){
        Page<DemandOrderBriefInfoVO> page =new Page<>(pageParamDTO.getPageOn(),pageParamDTO.getPageSize());
        //获取用户所拥有的权限id
        List<String> authorityList = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityList.add(s.getAuthority());
        });
        //接下来根据部门和权限做出相应的回应
        //阳光用户
        if (authorityList.contains("报价")){
            return null;
        }
        //获取用户所在部门
        String dept = userDao.getUserDept(userId).getDeptName();
        if (authorityList.contains("审核")&&dept.equals("电厂")){
            return demandOrderDao.getDemandOrderBriefInfoQuoted(page,0);
        }else if (authorityList.contains("审批")&&dept.equals("电厂")){
            return demandOrderDao.getDemandOrderBriefInfoQuoted(page,1);
        }else if (authorityList.contains("审核")&&dept.equals("子公司")){
            return demandOrderDao.getDemandOrderBriefInfoQuoted(page,2);
        }
        return null;
    }

    //合同简要信息回显
    @Override
    public IPage<ContractBriefVO> getContractBrief(PageParamDTO pageParamDTO, Integer userId){
        Page<ContractPO> page =new Page<>(pageParamDTO.getPageOn(),pageParamDTO.getPageSize());
        //获取用户所拥有的权限id
        List<String> authorityList = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityList.add(s.getAuthority());
        });
        //获取用户所在部门
        String dept = userDao.getUserDept(userId).getDeptName();
        if (authorityList.contains("审批")&&dept.equals("电厂")){
            return contractDao.getContractBrief(page);
        }
        return null;

    }

    //保存需求订单回显
    @Override
    public SaveDemandOrderPO SaveDemandEcho() {
        //在保存订单的数据中，在某一时刻只能最多保存一个
        QueryWrapper wrapper = new QueryWrapper();
        return saveDemandOrderMapper.selectOne(wrapper);
    }

    //保存报价订单回显
    @Override
    public SaveQuotedPriceInfoPO SaveQuotedPriceEcho() {
        QueryWrapper wrapper = new QueryWrapper();
        return saveQuotedPriceInfoMapper.selectOne(wrapper);
    }
}
