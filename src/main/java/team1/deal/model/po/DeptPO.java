package team1.deal.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("dept")
@ApiModel(value="DeptPO对象", description="部门类")
public class DeptPO implements Serializable {


    @ApiModelProperty(value = "部门id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "部门名")
    @TableField("deptName")
    private String deptName;


}
