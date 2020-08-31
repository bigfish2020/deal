package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description="雷达图")
@Data
public class RadarMapVO {
    @ApiModelProperty(value = "煤种")
    private String coalType;
    @ApiModelProperty(value = "城市分类")
    private String producingArea;
    @ApiModelProperty(value = "煤炭数量")
    private long count;
}
