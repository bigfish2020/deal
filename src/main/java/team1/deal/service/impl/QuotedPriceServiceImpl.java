package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.dto.QuotedPriceIdListDTO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.service.QuotedPriceService;

import java.util.List;

@Service
public class QuotedPriceServiceImpl implements QuotedPriceService {

    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;


    //报价批量审核/审批通过
    @Transactional
    @Override
    public void batchauditAllow(QuotedPriceIdListDTO quotedPriceIdListDTO) {
        List<Integer> idlist = quotedPriceIdListDTO.getQuotedPriceIdList();
        for (Integer id:idlist){
            QuotedPriceInfoPO quotedPriceInfoPO = quotedPriceInfoMapper.selectById(id);
            quotedPriceInfoPO.setStatus(quotedPriceInfoPO.getStatus()+1);
            //将修改的结果存入数据库
            quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
        }
    }


    //报价批量审核/审批不通过
    @Transactional
    @Override
    public void batchauditFailure(QuotedPriceIdListDTO quotedPriceIdListDTO) {

        List<Integer> idlist = quotedPriceIdListDTO.getQuotedPriceIdList();
        for (Integer id:idlist){
            QuotedPriceInfoPO quotedPriceInfoPO = quotedPriceInfoMapper.selectById(id);
            quotedPriceInfoPO.setStatus(-1);
            //将修改的结果存入数据库
            quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
        }
    }

}
