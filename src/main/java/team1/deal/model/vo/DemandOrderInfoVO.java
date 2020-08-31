package team1.deal.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "订单信息")
@Data
public class DemandOrderInfoVO {

    @ApiModelProperty(value = "需求订单id")
    private Integer id;
    
    @ApiModelProperty("申请人")
    private String name;

    @ApiModelProperty("单据编号")
    private String receiptNumber;

    @ApiModelProperty(value = "审核意见")
    private String idea;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态，3：子公司一级审核通过状态，4：一级审核通过状态，5完成状态，-1：待修改状态,-2：未创建状态")
    private Integer status;

    @ApiModelProperty(value = "报价截止时间")
    private LocalDateTime lastTime;

    @ApiModelProperty(value = "申请单位")
    private String applyUnit;

    @ApiModelProperty(value = "申请日期")
    private LocalDateTime applyTime;

    @ApiModelProperty(value = "交货日期")
    private LocalDateTime deliveryTime;

    @ApiModelProperty(value = "煤炭种类")
    private String coalType;

    @ApiModelProperty(value = "采购数量")
    private Integer coalNumber;

    @ApiModelProperty(value = "运输方式")
    private String transportType;

    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;

    @ApiModelProperty(value = "结算方式")
    private String paymentType;

    @ApiModelProperty(value = "验收方式")
    private String checkType;

    @ApiModelProperty(value = "最高限价，不能为空")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "最低限价,可以为空")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "限价说明")
    private String priceDescription;

    @ApiModelProperty(value = "每吨煤,报价保证金额")
    private BigDecimal offerMargin;

    @ApiModelProperty(value = "每吨煤,执行保证金额")
    private BigDecimal performMargin;

    @ApiModelProperty(value = "热值")
    private BigDecimal calorificValue;

    @ApiModelProperty(value = "全硫")
    private BigDecimal sulfurContent;

    @ApiModelProperty(value = "挥发分")
    private BigDecimal volatileQuantity;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;
}
