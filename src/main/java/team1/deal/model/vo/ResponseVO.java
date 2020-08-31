package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一响应数据格式
 *
 */
@Data
@ApiModel(description = "统一响应对象")
public class ResponseVO<T> {

    @ApiModelProperty("响应码")
    private Integer code;

    @ApiModelProperty("响应消息")
    private String message;

    @ApiModelProperty("响应数据")
    private T data;

    public ResponseVO(Integer code) {
        this.code = code;
    }

    public ResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVO(T data) {
        this.code=200;
        this.message="ok";
        this.data = data;
    }
}
