package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team1.deal.model.po.DemandOrderPO;
import team1.deal.model.po.SaveDemandOrderPO;
import team1.deal.model.po.UserPO;
import team1.deal.model.vo.MessageResponseVO;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.CreatDemandService;
import team1.deal.service.DemandOrderService;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "创建|保存需求")
@RequestMapping(value = "/creatDemand")
public class CreatDemandController {

    @Autowired
    private CreatDemandService creatDemandService;

    @Autowired
    private DemandOrderService demandOrderService;

    @Autowired
    private RedisTemplate<Object, UserPO> redisTemplate;


    @ApiOperation("需求点击创建")
    @PostMapping(value = "/buttonCreatDemand")
    public ResponseVO CreatDemand(HttpServletRequest request,@RequestBody @Validated DemandOrderPO demandOrderPO){
        creatDemandService.CreatDemand(request,demandOrderPO);
        return new MessageResponseVO(20005);
    }

    @ApiOperation("需求点击保存")
    @PostMapping(value = "/buttonSaveDemand")
    public ResponseVO SaveDemand(HttpServletRequest request,@RequestBody @Validated SaveDemandOrderPO saveDemandOrderPO){
        creatDemandService.SaveDemand(request,saveDemandOrderPO);
        return new MessageResponseVO(20006);
    }

    @ApiOperation("审核不通过修改按钮订单信息回显")
    @GetMapping(value = "/OrderInfo/{orderId}")
    public ResponseVO changeButtonOrderInfo(@ApiParam("需求订单id") @PathVariable Integer orderId, HttpServletRequest httpServletRequest){
        DemandOrderPO demandOrderPO = demandOrderService.getById(orderId);
        SaveDemandOrderPO saveDemandOrderPO = new SaveDemandOrderPO();
        BeanUtils.copyProperties(demandOrderPO,saveDemandOrderPO);
        creatDemandService.SaveDemand(httpServletRequest,saveDemandOrderPO);
        return new ResponseVO(demandOrderPO);
    }
}
