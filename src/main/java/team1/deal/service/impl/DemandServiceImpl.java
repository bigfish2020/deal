package team1.deal.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.service.DemandService;

@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandOrderMapper demandOrderMapper;


    //审核/审批通过
    @Override
    public void auditAllow(DemandOrderPO demandOrderPO) {
        demandOrderPO.setStatus(demandOrderPO.getStatus()+1);
        //将修改的结果存入数据库
        demandOrderMapper.updateById(demandOrderPO);
    }

    //审核/审批不通过
    @Override
    public void auditFailure(DemandOrderPO demandOrderPO) {
        demandOrderPO.setStatus(-1);
        //将修改的结果存入数据库
        demandOrderMapper.updateById(demandOrderPO);
    }


}
