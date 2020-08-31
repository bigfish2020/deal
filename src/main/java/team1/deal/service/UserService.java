package team1.deal.service;

import team1.deal.model.po.UserPO;
import com.baomidou.mybatisplus.extension.service.IService;
import team1.deal.model.vo.QuotedPriceInfoVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author team1
 * @since 2020-08-05
 */
public interface UserService extends IService<UserPO> {
    List<QuotedPriceInfoVO> selectSupplier(Integer orderId,Integer userId);
}
