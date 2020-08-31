package team1.deal.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import team1.deal.model.vo.ContractBriefVO;
import team1.deal.model.vo.ContractVO;

import java.util.List;

public interface ContractDao {
    //获取合同简要信息
    Page<ContractBriefVO> getContractBrief(@Param("page") Page page);
    //获取合同信息
    ContractVO getContractVO(@Param("contractId")Integer contractId);
}
