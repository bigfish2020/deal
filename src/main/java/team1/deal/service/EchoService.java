package team1.deal.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import team1.deal.model.dto.PageParamDTO;
import team1.deal.model.po.ContractPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;
import team1.deal.model.vo.ContractBriefVO;
import team1.deal.model.vo.DemandOrderBriefInfoVO;
import team1.deal.model.vo.DemandOrderInfoVO;

import java.util.List;

public interface EchoService {

     IPage<DemandOrderBriefInfoVO> getDemandOrderBriefInfo(PageParamDTO pageParamDTO, Integer userId);

     IPage<DemandOrderBriefInfoVO> getDemandOrderBriefInfoQuoted(PageParamDTO pageParamDTO, Integer userId);

     IPage<ContractBriefVO> getContractBrief(PageParamDTO pageParamDTO, Integer userId);

     //保存需求订单回显
     public SaveDemandOrderPO SaveDemandEcho();

     //保存报价订单回显
     public SaveQuotedPriceInfoPO SaveQuotedPriceEcho();

}
