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
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("save_quoted_price_info")
@ApiModel(value="SaveQuotedPriceInfoPO对象", description="")
public class SaveQuotedPriceInfoPO implements Serializable {


    @ApiModelProperty(value = "表单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "需求订单id")
    @TableField("dId")
    private Integer dId;

    @ApiModelProperty(value = "供应商id（在user表中）")
    @TableField("uId")
    private Integer uId;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态， *3：子公司审批通过状态，4：完成状态，-1：出局状态，-2保存状态")
    private Integer status;

    @ApiModelProperty(value = "供货量")
    @TableField("supplyQuantity")
    private Integer supplyQuantity;

    @ApiModelProperty(value = "热值")
    @TableField("calorificValue")
    private BigDecimal calorificValue;

    @ApiModelProperty(value = "原煤单价")
    @TableField("rawCoalPrice")
    private BigDecimal rawCoalPrice;

    @ApiModelProperty(value = "全硫")
    @TableField("sulfurContent")
    private BigDecimal sulfurContent;

    @ApiModelProperty(value = "产地")
    @TableField("producingArea")
    private String producingArea;

    @ApiModelProperty(value = "运费单价")
    @TableField("itemPrice")
    private BigDecimal itemPrice;

    @ApiModelProperty(value = "挥发分")
    @TableField("volatileQuantity")
    private BigDecimal volatileQuantity;

    @ApiModelProperty(value = "发货港口")
    private String port;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal aad;

    @ApiModelProperty(value = "全水分")
    @TableField("totalMoisture")
    private BigDecimal totalMoisture;
}
