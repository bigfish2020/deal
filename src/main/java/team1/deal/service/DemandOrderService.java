package team1.deal.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.DemandOrderPO;
import com.baomidou.mybatisplus.extension.service.IService;
import team1.deal.model.vo.DemandOrderBriefInfoVO;
import team1.deal.model.vo.DemandOrderInfoVO;
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
public interface DemandOrderService extends IService<DemandOrderPO> {

    Page<DemandOrderBriefInfoVO> getDemandOrderByPage (PageParamDTO pageParamDTO);

    List<QuotedPriceInfoVO> getQuotedPriceInfoList(Integer id);

    DemandOrderInfoVO getDemandOrderById (Integer id);

}
