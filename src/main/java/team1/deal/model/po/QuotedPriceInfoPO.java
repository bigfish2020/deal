package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

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
@TableName("quoted_price_info")
@ApiModel(value="QuotedPriceInfoPO对象", description="报价订单类")
public class QuotedPriceInfoPO implements Serializable {


    @ApiModelProperty(value = "表单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Range(min = 1)
    @NotNull
    @ApiModelProperty(value = "需求订单id")
    @TableField("dId")
    private Integer dId;

    @ApiModelProperty(value = "供应商id（在user表中）")
    @TableField("uId")
    private Integer uId;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态， *3：子公司审批通过状态，4：完成状态，-1：出局状态，-2保存状态")
    private Integer status;

    @NotNull
    @ApiModelProperty(value = "供货量")
    @TableField("supplyQuantity")
    private Integer supplyQuantity;

    @NotNull
    @ApiModelProperty(value = "热值")
    @TableField("calorificValue")
    private BigDecimal calorificValue;

    @NotNull
    @ApiModelProperty(value = "原煤单价")
    @TableField("rawCoalPrice")
    private BigDecimal rawCoalPrice;

    @NotNull
    @ApiModelProperty(value = "全硫")
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    @NotBlank
    @ApiModelProperty(value = "产地")
    @TableField("producingArea")
    private String producingArea;

    @NotNull
    @ApiModelProperty(value = "运费单价")
    @TableField("itemPrice")
    private BigDecimal itemPrice;

    @NotNull
    @ApiModelProperty(value = "挥发分")
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    @NotBlank
    @ApiModelProperty(value = "发货港口")
    private String port;

    @NotNull
    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;

    @NotNull
    @ApiModelProperty(value = "全水分")
    @TableField("totalMoisture")
    private BigDecimal totalMoisture;


}
