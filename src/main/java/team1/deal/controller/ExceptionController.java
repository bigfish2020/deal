package team1.deal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import team1.deal.config.properties.CodeMessageProperties;
import team1.deal.model.vo.ExceptionResponseVO;

//统一异常处理
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @Autowired
    private CodeMessageProperties codeMessageProperties;

    /**
     * 未知异常
     *
     * @param runtimeException 运行时异常
     * @return 异常信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseVO runtimeException(RuntimeException runtimeException) {
        log.error("系统出现错误", runtimeException);
        return new ExceptionResponseVO(50000,runtimeException.getMessage());
    }
    /**
     * Bean Validator 参数校验异常处理
     *
     * @param e 参数校验异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponseVO methodArgumentNotValidException(MethodArgumentNotValidException e) {
        String validMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ExceptionResponseVO(40000, "参数格式错误", validMessage);
    }

    /**
     * controller 层参数格式转换异常
     *
     * @param e 参数转换异常
     * @return 异常信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ExceptionResponseVO methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ExceptionResponseVO(40000, "参数格式错误");
    }
}
