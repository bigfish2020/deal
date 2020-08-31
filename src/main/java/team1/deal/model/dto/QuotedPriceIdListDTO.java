package team1.deal.model.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@ApiModel(value="QuotedPriceIdListDTO对象", description="接收批量报价id以及审核意见信息")
public class QuotedPriceIdListDTO {
    @ApiModelProperty(value = "报价id集合")
    private List<Integer> quotedPriceIdList;
}
