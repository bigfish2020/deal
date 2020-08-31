package team1.deal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.mapper.SaveDemandOrderMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.UserPO;
import team1.deal.service.CreatDemandService;

import javax.servlet.http.HttpServletRequest;

@Service
public class CreatDemandServiceImpl implements CreatDemandService {

    @Autowired
    private DemandOrderMapper demandOrderMapper;
    @Autowired
    private SaveDemandOrderMapper saveDemandOrderMapper;
    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;


    //创建需求
    @Override
    public void CreatDemand(HttpServletRequest request,DemandOrderPO demandOrderPO) {

        //判断需求订单表中有无
        if (demandOrderMapper.selectById(demandOrderPO.getId())==null){
            //没有，则插入
            //设置需求订单的状态
            demandOrderPO.setStatus(0);
            //将需求订单的id设置为null,防止保存的id与提交后的id冲突
            demandOrderPO.setId(null);

            String Token = request.getHeader("Token");
            //在redis中查询
            UserPO userPO = redisTemplate.opsForValue().get(Token);
            demandOrderPO.setUId(userPO.getId());
            demandOrderMapper.insert(demandOrderPO);
        }else {
            //有，则修改
            demandOrderMapper.updateById(demandOrderPO);
        }
    }


    //保存需求
    @Override
    public void SaveDemand(HttpServletRequest request, SaveDemandOrderPO saveDemandOrderPO) {
        //设置需求订单的状态为-2代表没有
        saveDemandOrderPO.setStatus(-2);

        //判断保存表中有无已保存的数据，有则删除旧，保存新的
        QueryWrapper wrapper = new QueryWrapper();
        SaveDemandOrderPO saveDemandOrderPO1 = saveDemandOrderMapper.selectOne(wrapper);
        if (saveDemandOrderPO1!=null){
            //删除旧数据
            saveDemandOrderMapper.deleteById(saveDemandOrderPO1.getId());
        }
        String Token = request.getHeader("Token");
        //在redis中查询
        UserPO userPO = redisTemplate.opsForValue().get(Token);
        saveDemandOrderPO.setUId(userPO.getId());
        saveDemandOrderMapper.insert(saveDemandOrderPO);
    }


}
