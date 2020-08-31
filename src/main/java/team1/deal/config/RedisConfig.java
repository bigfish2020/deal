package team1.deal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import team1.deal.model.po.UserPO;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, UserPO> personRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, UserPO> template = new RedisTemplate<Object, UserPO>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<UserPO> serializer = new Jackson2JsonRedisSerializer<UserPO>(UserPO.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

}
