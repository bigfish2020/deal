package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("demand_order")
@ApiModel(value="DemandOrderPO对象", description="需求订单类")
public class DemandOrderPO implements Serializable {

    @ApiModelProperty(value = "需求订单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField("uId")
    private Integer uId;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态，3：子公司一级审核通过状态，4：子公司二级审核通过状态，5完成状态，-1：待修改状态,-2：未创建状态")
    private Integer status;

    @ApiModelProperty(value = "审核意见")
    private String idea;

    @NotNull(message = "报价截止时间八八八八")
    @Future
    @ApiModelProperty(value = "报价截止时间")
    @TableField("lastTime")
    private LocalDateTime lastTime;

    @NotBlank(message = "申请单位八八八八")
    @ApiModelProperty(value = "申请单位")
    @TableField("applyUnit")
    private String applyUnit;

    @NotNull(message = "申请日期八八八八")
    @ApiModelProperty(value = "申请日期")
    @TableField("applyTime")
    private LocalDateTime applyTime;

    @NotNull(message = "交货日期八八八八")
    @Future
    @ApiModelProperty(value = "交货日期")
    @TableField("deliveryTime")
    private LocalDateTime deliveryTime;

    @NotBlank(message = "煤炭种类不合法")
    @ApiModelProperty(value = "煤炭种类")
    @TableField("coalType")
    private String coalType;

    @NotNull(message = "采购数量八八八八")
    @ApiModelProperty(value = "采购数量")
    @TableField("coalNumber")
    private Integer coalNumber;

    @NotBlank(message = "运输方式八八八八")
    @ApiModelProperty(value = "运输方式")
    @TableField("transportType")
    private String transportType;

    @NotBlank@NotBlank(message = "交货地点八八八八")
    @ApiModelProperty(value = "交货地点")
    @TableField("deliveryPlace")
    private String deliveryPlace;

    @NotBlank@NotBlank(message = "结算方式八八八八")
    @ApiModelProperty(value = "结算方式")
    @TableField("paymentType")
    private String paymentType;

    @NotBlank(message = "验收方式八八八八")
    @ApiModelProperty(value = "验收方式")
    @TableField("checkType")
    private String checkType;

    @NotNull(message = "最高限价，不能为空八八八八")
    @ApiModelProperty(value = "最高限价，不能为空")
    @TableField("maxPrice")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "最低限价,可以为空")
    @TableField("minPrice")
    private BigDecimal minPrice;

    @NotBlank(message = "限价说明八八八八")
    @ApiModelProperty(value = "限价说明")
    @TableField("priceDescription")
    private String priceDescription;

    @NotNull(message = "每吨煤,报价保证金额八八八八")
    @ApiModelProperty(value = "每吨煤,报价保证金额")
    @TableField("offerMargin")
    private BigDecimal offerMargin;

    @NotNull(message = "每吨煤,执行保证金额八八八八")
    @ApiModelProperty(value = "每吨煤,执行保证金额")
    @TableField("performMargin")
    private BigDecimal performMargin;

    @NotNull(message = "热值八八八八")
    @ApiModelProperty(value = "热值")
    @TableField("calorificValue")
    private BigDecimal calorificValue;

    @NotNull(message = "全硫八八八八")
    @ApiModelProperty(value = "全硫")
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    @NotNull(message = "挥发分八八八八")
    @ApiModelProperty(value = "挥发分")
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    @NotNull(message = "空干基灰分八八八八")
    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;


}
