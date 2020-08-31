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
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("save_demand_order")
@ApiModel(value="SaveDemandOrderPO对象", description="")
public class SaveDemandOrderPO implements Serializable {


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

    @Future
    @NotNull
    @ApiModelProperty(value = "报价截止时间")
    @TableField("lastTime")
    private LocalDateTime lastTime;

    @NotBlank
    @ApiModelProperty(value = "申请单位")
    @TableField("applyUnit")
    private String applyUnit;

    @Future
    @NotNull
    @ApiModelProperty(value = "申请日期")
    @TableField("applyTime")
    private LocalDateTime applyTime;

    @Future
    @NotNull
    @ApiModelProperty(value = "交货日期")
    @TableField("deliveryTime")
    private LocalDateTime deliveryTime;

    @ApiModelProperty(value = "煤炭种类")
    @TableField("coalType")
    private String coalType;

    @ApiModelProperty(value = "采购数量")
    @TableField("coalNumber")
    private Integer coalNumber;

    @ApiModelProperty(value = "运输方式")
    @TableField("transportType")
    private String transportType;

    @ApiModelProperty(value = "交货地点")
    @TableField("deliveryPlace")
    private String deliveryPlace;

    @ApiModelProperty(value = "结算方式")
    @TableField("paymentType")
    private String paymentType;

    @ApiModelProperty(value = "验收方式")
    @TableField("checkType")
    private String checkType;

    @ApiModelProperty(value = "最高限价，不能为空")
    @TableField("maxPrice")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "最低限价,可以为空")
    @TableField("minPrice")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "限价说明")
    @TableField("priceDescription")
    private String priceDescription;

    @ApiModelProperty(value = "每吨煤,报价保证金额")
    @TableField("offerMargin")
    private BigDecimal offerMargin;

    @ApiModelProperty(value = "每吨煤,执行保证金额")
    @TableField("performMargin")
    private BigDecimal performMargin;

    @ApiModelProperty(value = "热值")
    @TableField("calorificValue")
    private BigDecimal calorificValue;

    @ApiModelProperty(value = "全硫")
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    @ApiModelProperty(value = "挥发分")
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;


}
