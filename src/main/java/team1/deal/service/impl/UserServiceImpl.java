package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import team1.deal.dao.UserDao;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.UserPO;
import team1.deal.mapper.UserMapper;
import team1.deal.model.vo.QuotedPriceInfoVO;
import team1.deal.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;


    public List<QuotedPriceInfoVO> selectSupplier(Integer orderId,Integer userId){
        //获取用户所在部门
        String dept = userDao.getUserDept(userId).getDeptName();
        //获取用户所拥有的权限id
        List<String> authorityList = new ArrayList<>();
        userDao.getUserAuthority(userId).forEach(s->{
            authorityList.add(s.getAuthority());
        });
        QueryWrapper<QuotedPriceInfoPO> wrapper =new QueryWrapper<>();
        if (authorityList.contains("审核")&&dept.equals("电厂")){
            wrapper.eq("status",0).eq("dId",orderId);
            return changeToVO(quotedPriceInfoMapper.selectList(wrapper));
        }else if (authorityList.contains("审批")&&dept.equals("电厂")){
            wrapper.eq("status",1).eq("dId",orderId);
            return changeToVO(quotedPriceInfoMapper.selectList(wrapper));
        }else if (authorityList.contains("审核")&&dept.equals("子公司")){
            wrapper.eq("status",2).eq("dId",orderId);
            return changeToVO(quotedPriceInfoMapper.selectList(wrapper));
        }
        return null;
    }

    //订单类转返回消息
    private List<QuotedPriceInfoVO> changeToVO(List<QuotedPriceInfoPO> list){
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
}
