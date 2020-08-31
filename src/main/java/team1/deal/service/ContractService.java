package team1.deal.service;

import org.springframework.web.multipart.MultipartFile;
import team1.deal.model.po.ContractPO;
import com.baomidou.mybatisplus.extension.service.IService;
import team1.deal.model.vo.ContractVO;

import java.io.IOException;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team1
 * @since 2020-08-10
 */
public interface ContractService extends IService<ContractPO> {

    //上传合同附件，创建合同，并保存到数据库中
    public void CreatContract(MultipartFile file, ContractPO contractPO) throws IOException;


    //合同执行完毕
    public void CompleteContract(ContractPO contractPO);

    //返回合同信息
    ContractVO getContractVO(Integer contractId);
}
