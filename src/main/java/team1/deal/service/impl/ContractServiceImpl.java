package team1.deal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import team1.deal.dao.ContractDao;
import team1.deal.mapper.DemandOrderMapper;
import team1.deal.mapper.QuotedPriceInfoMapper;
import team1.deal.model.po.ContractPO;
import team1.deal.mapper.ContractMapper;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.QuotedPriceInfoPO;
import team1.deal.model.vo.ContractVO;
import team1.deal.service.ContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author team1
 * @since 2020-08-10
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, ContractPO> implements ContractService {

    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private DemandOrderMapper demandOrderMapper;
    @Autowired
    private QuotedPriceInfoMapper quotedPriceInfoMapper;

    //上传合同附件，创建合同，并保存到数据库中
    @Transactional
    @Override
    public void CreatContract(MultipartFile file, ContractPO contractPO) throws IOException {
        //上传合同
        String url = null;
        //构建上传之后的地址
        String path = System.getProperty("user.dir") + "\\ContractFolder";
        //将当前时间转换成时间戳
        long longtime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Integer dId = quotedPriceInfoMapper.selectById(contractPO.getQId()).getDId();
        contractPO.setDId(dId);
        //将时间戳和原名加一起，保证了名字的唯一性
        String fileName = longtime + file.getOriginalFilename();
        //判断路径是否存在，不存在则新创建一个
        File filepath = new File(path, fileName);
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将文件上传到指定的位置
        file.transferTo(new File(path + File.separator + fileName));
        //拼写完整的路径
        url = path + "\\" + fileName;
        //将url信息存入contractPO对象中
        contractPO.setUrl(url);
        //设置合同的初始状态
        contractPO.setStatus(0);
        //将合同存入数据库
        contractMapper.insert(contractPO);
        //将需求订单的状态设置为5，表示完成
        DemandOrderPO demandOrderPO = demandOrderMapper.selectById(contractPO.getDId());
        demandOrderPO.setStatus(5);
        demandOrderMapper.updateById(demandOrderPO);
        //将报价订单的状态设置为4，表示完成
        QuotedPriceInfoPO quotedPriceInfoPO = quotedPriceInfoMapper.selectById(contractPO.getQId());
        quotedPriceInfoPO.setStatus(4);
        quotedPriceInfoMapper.updateById(quotedPriceInfoPO);
    }
    //合同执行完毕
    @Override
    public void CompleteContract(ContractPO contractPO) {
        contractPO.setStatus(1);
        //将修改为完毕状态的contractPO在数据库中更新
        contractMapper.updateById(contractPO);
    }

    @Override
    public ContractVO getContractVO(Integer contractId) {
       return  contractDao.getContractVO(contractId);
    }
}
