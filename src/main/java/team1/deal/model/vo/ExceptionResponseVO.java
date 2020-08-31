package team1.deal.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
//异常返回视图
public class ExceptionResponseVO extends MessageResponseVO {
    //异常信息
    private String detail;

    public ExceptionResponseVO(Integer code){
        super(code);
    }

    public ExceptionResponseVO(Integer code,String detail){
        super(code);
        this.detail=detail;
    }

    public ExceptionResponseVO(Integer code, String message, String detail) {
        super(code, message);
        this.detail = detail;
    }
}
