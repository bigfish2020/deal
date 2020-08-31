package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel(description="报价信息")
@Data
public class QuotedPriceInfoVO {


    @ApiModelProperty(value = "表单id")
    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    private String name;

    @ApiModelProperty(value = "供应商类别")
    private String type;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态， *3：子公司一级审核通过状态，4：完成状态，-1：出局状态")
    private Integer status;

    @ApiModelProperty(value = "供货量")
    private Integer supplyQuantity;

    @ApiModelProperty(value = "热值")
    private BigDecimal calorificValue;

    @ApiModelProperty(value = "原煤单价")
    private BigDecimal rawCoalPrice;

    @ApiModelProperty(value = "全硫")
    private BigDecimal sulfurContent;

    @ApiModelProperty(value = "产地")
    private String producingArea;

    @ApiModelProperty(value = "运费单价")
    private BigDecimal itemPrice;

    @ApiModelProperty(value = "挥发分")
    private BigDecimal volatileQuantity;

    @ApiModelProperty(value = "发货港口")
    private String port;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;

    @ApiModelProperty(value = "全水分")
    private BigDecimal totalMoisture;
}
