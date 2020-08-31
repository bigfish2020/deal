package team1.deal.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties(CodeMessageProperties.class)
@PropertySource(value = "classpath:code-message.properties",encoding = "utf-8")
@ConfigurationProperties
@Data
public class CodeMessageProperties {
    //消息码
    private Map<Integer,String> codeMessage =new HashMap<>();
}
