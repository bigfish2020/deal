package team1.deal.dao;

import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.DeptPO;

public interface DeptDao {

    //根据用户id获得他所在的部门
    DeptPO getDeptByUserId(@Param("id") Integer id);

}
