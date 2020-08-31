package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="CoalYearNameGdpVO对象", description="用来接收折线图中煤炭的数据")
public class CoalYearNameGdpVO {

    @ApiModelProperty(value = "煤炭名")
    private String coalType;
    @ApiModelProperty(value = "年")
    private String year;
    @ApiModelProperty(value = "数量")
    private long gdp;

    public CoalYearNameGdpVO(String coalType, String year, long gdp) {
        this.coalType = coalType;
        this.year = year;
        this.gdp = gdp;
    }

    public CoalYearNameGdpVO() {
    }
}
