package team1.deal.service;

import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;

import javax.servlet.http.HttpServletRequest;

public interface CreatDemandService {

    //创建需求
    public void CreatDemand(HttpServletRequest request, DemandOrderPO demandOrderPO);

    //保存需求
    public void SaveDemand(HttpServletRequest request,SaveDemandOrderPO saveDemandOrderPO);


}
