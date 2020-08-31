package team1.deal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@ApiModel(value = "分页参数")
public class PageParamDTO {

    @Range(min = 1,message = "页码格式不对")
    @ApiModelProperty("当前页码-从 1 开始")
    private Integer pageOn = 1;

    @Range(min = 10,max = 20,message = "每一页显示条数数量不对")
    @ApiModelProperty("每页条数")
    private Integer pageSize = 10;

}
