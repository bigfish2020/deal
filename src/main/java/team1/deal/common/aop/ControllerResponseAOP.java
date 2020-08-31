package team1.deal.common.aop;

import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team1.deal.config.properties.CodeMessageProperties;
import team1.deal.model.vo.MessageResponseVO;

@Component
@Aspect
public class ControllerResponseAOP {
    @Autowired
    private CodeMessageProperties codeMessage;

    @AfterReturning(returning = "messageResponseVO",pointcut = "execution (* team1.deal.controller..*.*(..))")
    public void  afterReturning(MessageResponseVO messageResponseVO){
        if (messageResponseVO==null){
            return;
        }
        int code = messageResponseVO.getCode();
        String oldCodeMessage=messageResponseVO.getMessage();
        String newCodeMessage=codeMessage.getCodeMessage().get(code);
        if (Strings.isEmpty(oldCodeMessage)) {
            messageResponseVO.setMessage(newCodeMessage);
        }
    }
}
