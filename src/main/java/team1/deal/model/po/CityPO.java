package team1.deal.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("city")
@ApiModel(value="CityPO对象", description="")
public class CityPO implements Serializable {


    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "城市名")
    @TableId(value = "cityName", type = IdType.AUTO)
    private String cityName;

    @Override
    public String toString() {
        return longitude + "," + latitude ;
    }
}
