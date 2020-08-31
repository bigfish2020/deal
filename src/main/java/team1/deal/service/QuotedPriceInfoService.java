package team1.deal.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import com.baomidou.mybatisplus.extension.service.IService;
import team1.deal.model.vo.DemandOrderInfoVO;
import team1.deal.model.vo.QuotedPriceBriefInfoVO;
import team1.deal.model.vo.QuotedPriceInfoVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
public interface QuotedPriceInfoService extends IService<QuotedPriceInfoPO> {
    IPage<QuotedPriceBriefInfoVO> getQuotedBriefList(PageParamDTO pageParamDTO,Integer userId);

    DemandOrderInfoVO getDemandOrder(Integer quotedId);

    QuotedPriceInfoVO getQuotedInfoVO(Integer quotedId);
}
