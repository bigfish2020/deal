package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.mapper.SaveQuotedPriceInfoMapper;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.po.UserPO;
import team1.deal.service.CreatQuotedPriceService;

import javax.servlet.http.HttpServletRequest;

@Service
public class CreatQuotedPriceServiceImpl implements CreatQuotedPriceService {

    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;
    @Autowired
    private SaveQuotedPriceInfoMapper saveQuotedPriceInfoMapper;
    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;

    //创建报价
    @Override
    public void CreatQuotedPrice(HttpServletRequest request, QuotedPriceInfoPO quotedPriceInfoPO) {
        //设置报价订单的状态
        quotedPriceInfoPO.setStatus(0);
        //将报价订单的id设置为null,防止保存的id与提交后的id冲突
        quotedPriceInfoPO.setId(null);
        String Token = request.getHeader("Token");
        //在redis中查询
        UserPO userPO = redisTemplate.opsForValue().get(Token);
        quotedPriceInfoPO.setUId(userPO.getId());
        quotedPriceInfoMapper.insert(quotedPriceInfoPO);
    }

    //保存报价
    @Override
    public void SaveQuotedPrice(HttpServletRequest request,SaveQuotedPriceInfoPO saveQuotedPriceInfoPO) {
        //设置报价订单的状态
        saveQuotedPriceInfoPO.setStatus(-2);
        //判断保存表中有无已保存的数据，有则删除旧，保存新的,确保保存表中在某一时刻只能有一条数据
        QueryWrapper wrapper = new QueryWrapper();
        SaveQuotedPriceInfoPO saveQuotedPriceInfoPO1 = saveQuotedPriceInfoMapper.selectOne(wrapper);
        if (saveQuotedPriceInfoPO1!=null){
            //删除旧数据
            saveQuotedPriceInfoMapper.deleteById(saveQuotedPriceInfoPO1.getId());
        }
        String Token = request.getHeader("Token");
        //在redis中查询
        UserPO userPO = redisTemplate.opsForValue().get(Token);
        saveQuotedPriceInfoPO.setUId(userPO.getId());
        saveQuotedPriceInfoMapper.insert(saveQuotedPriceInfoPO);
    }
}
