package team1.deal.service;

import team1.deal.model.dto.QuotedPriceIdListDTO;
import team1.deal.model.po.QuotedPriceInfoPO;

public interface QuotedPriceService {


    //报价批量审核/审批通过
    public void batchauditAllow(QuotedPriceIdListDTO quotedPriceIdListDTO);

    //报价批量审核/审批不通过
    public void batchauditFailure(QuotedPriceIdListDTO quotedPriceIdListDTO);


}
