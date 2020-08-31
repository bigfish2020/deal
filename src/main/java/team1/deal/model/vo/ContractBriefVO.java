package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("合同简要信息")
@Data
public class ContractBriefVO {
    @ApiModelProperty(value = "交易合同编号")
    private Integer transactionContractNumber;

    @ApiModelProperty(value = "供应商名称")
    private String name;

    @ApiModelProperty(value = "签署日期")
    private LocalDateTime signDate;

    @ApiModelProperty(value = "签约价格")
    private BigDecimal price;

    @ApiModelProperty(value = "签约量")
    private Integer amount;

    @ApiModelProperty(value = "合同状态，0：合同创建状态，1：合同完成状态")
    private Integer status;

}
