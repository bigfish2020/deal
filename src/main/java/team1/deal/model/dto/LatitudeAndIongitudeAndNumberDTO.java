package team1.deal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value = "依赖封装，两个地方的经纬度")
public class LatitudeAndIongitudeAndNumberDTO {
    @ApiModelProperty("发送地经纬度")
    private List<BigDecimal> port;
    @ApiModelProperty("目的地经纬度")
    private List<BigDecimal> deliveryPlace;

}
