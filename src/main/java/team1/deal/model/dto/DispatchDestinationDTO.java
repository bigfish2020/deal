package team1.deal.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "发送地-目的地")
public class DispatchDestinationDTO {
    @ApiModelProperty("发送地")
    private String port;
    @ApiModelProperty("目的地")
    private String deliveryPlace;

}
