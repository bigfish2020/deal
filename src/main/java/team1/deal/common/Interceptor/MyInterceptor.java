package team1.deal.common.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import team1.deal.model.po.UserPO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 拦截器
 * 用于验证用户的合法性
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String Token = request.getHeader("Token");

        //在redis中查询，如果有该用户，则合法
        UserPO userPO = redisTemplate.opsForValue().get(Token);
        if (userPO != null){
            //合法
            //重置过期时间,保证用户登录后只要是在操作就不会过期，登陆后不操作1小时过期
            redisTemplate.expire(Token,1L, TimeUnit.HOURS);
            System.out.println("放行");
            return true;
        }else {
            System.out.println("拦截");
            return false;
        }
    }
}
