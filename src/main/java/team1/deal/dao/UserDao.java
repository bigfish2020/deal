package team1.deal.dao;

import org.apache.ibatis.annotations.Param;
import team1.deal.model.po.AuthorityPO;
import team1.deal.model.po.DeptPO;

import java.util.List;

public interface UserDao {
    //根据用户id返回用户所在部门
    DeptPO getUserDept(@Param("id") Integer id);

    //根据用户id返回用户所拥有的权限
    List<AuthorityPO> getUserAuthority(@Param("id") Integer id);

}
