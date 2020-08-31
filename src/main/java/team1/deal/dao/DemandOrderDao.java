package team1.deal.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.DemandOrderBriefInfoVO;

import java.time.LocalDateTime;
import java.util.List;

public interface DemandOrderDao {

    //根据订单id获取所有的报价信息
     List<QuotedPriceInfoPO> getQuotedPriceInfoList(@Param("id") Integer id);

     //获取需求订单简要信息分页
     IPage<DemandOrderBriefInfoVO> getDemandOrderBriefInfo(@Param("page") Page<DemandOrderBriefInfoVO> page, @Param("userId") Integer uId, @Param("status") Integer status, @Param("lastTime") LocalDateTime localDateTime);

    //报价阶段获取需求订单简要信息分页
    IPage<DemandOrderBriefInfoVO> getDemandOrderBriefInfoQuoted(@Param("page") Page<DemandOrderBriefInfoVO> page,@Param("status") Integer status);
}
