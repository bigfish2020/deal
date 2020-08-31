package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="CoalInformationVO对象", description="用来接收地区煤炭的相关数据")
public class CoalInformationVO {
    @ApiModelProperty(value = "煤炭名")
    private String coalType;
    @ApiModelProperty(value = "煤炭地区")
    private String producingArea;
    @ApiModelProperty(value = "数量")
    private long count;

    public CoalInformationVO(String coalType, String producingArea, long count) {
        this.coalType = coalType;
        this.producingArea = producingArea;
        this.count = count;
    }

    public CoalInformationVO() {
    }
}
