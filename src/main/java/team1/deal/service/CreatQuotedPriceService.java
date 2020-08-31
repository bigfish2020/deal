package team1.deal.service;

import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.po.SaveQuotedPriceInfoPO;

import javax.servlet.http.HttpServletRequest;

public interface CreatQuotedPriceService {

    //创建报价
    public void CreatQuotedPrice(HttpServletRequest request, QuotedPriceInfoPO quotedPriceInfoPO);

    //保存报价
    public void SaveQuotedPrice(HttpServletRequest request,SaveQuotedPriceInfoPO saveQuotedPriceInfoPO);


}
