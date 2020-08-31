package team1.deal.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("需求订单简要信息")
public class DemandOrderBriefInfoVO {
    @ApiModelProperty(value = "需求订单id")
    private Integer id;

    @ApiModelProperty(value = "状态代码（0：待审核状态，1：电厂一级审核通过状态，2：电厂二级审核通过状态，3：子公司一级审核通过状态，4：子公司二级审核通过状态，5完成状态，-1：待修改状态,-2：未创建状态")
    private Integer status;

    @ApiModelProperty(value = "煤炭种类")
    @TableField("coalType")
    private String coalType;

    @ApiModelProperty(value = "采购数量")
    @TableField("coalNumber")
    private Integer coalNumber;

    @ApiModelProperty(value = "交货地点")
    private String deliveryPlace;

    @ApiModelProperty(value = "交货日期")
    @TableField("deliveryTime")
    private LocalDateTime deliveryTime;

    @ApiModelProperty(value = "报价截止时间")
    @TableField("lastTime")
    private LocalDateTime lastTime;
}
