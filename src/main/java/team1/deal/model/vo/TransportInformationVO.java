package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="TransportInformationVO对象", description="用来接收运输方式的相关数据")
public class TransportInformationVO {
    @ApiModelProperty(value = "运输方式")
    private String transportType;
    @ApiModelProperty(value = "次数")
    private long count;

    public TransportInformationVO(String transportType, long count) {
        this.transportType = transportType;
        this.count = count;
    }

    public TransportInformationVO() {
    }
}
