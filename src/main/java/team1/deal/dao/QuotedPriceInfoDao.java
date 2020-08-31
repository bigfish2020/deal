package team1.deal.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.CityPO;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;

import java.util.List;

public interface QuotedPriceInfoDao {
    DemandOrderPO getDemandOrder(@Param("id") Integer id);

    //返回简要报价信息
    IPage<QuotedPriceBriefInfoVO> getQuotedPriceBriefInfo(@Param("page")Page<QuotedPriceBriefInfoVO> page, @Param("id") Integer userId,@Param("status")Integer status);

    List<CityPO> getDeliveryPlace();
}
