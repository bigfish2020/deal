package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description="报价简要信息")
public class QuotedPriceBriefInfoVO {

    @ApiModelProperty(value = "表单id")
    private Integer id;

    @ApiModelProperty(value = "煤炭种类")
    private String coalType;

    @ApiModelProperty(value = "采购数量")
    private Integer coalNumber;

    @ApiModelProperty(value = "供应商名称")
    private String name;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态，3：审批通过状态，4：完成状态，-1：出局状态")
    private Integer status;

    @ApiModelProperty(value = "供货量")
    private Integer supplyQuantity;
}
