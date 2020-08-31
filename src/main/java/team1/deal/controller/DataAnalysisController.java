package team1.deal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team1.deal.dao.DataAnalysisDao;
import team1.deal.model.vo.ResponseVO;
import team1.deal.service.DataAnalysisService;

@RestController
@RequestMapping("/data")
@Api(tags = "数据分析")
public class DataAnalysisController{

    @Autowired
    private DataAnalysisService dataAnalysisService;

    @GetMapping("/sunUserNumber")
    @ApiOperation("阳光用户数量")
    public ResponseVO getSunUser(){
        return new ResponseVO(dataAnalysisService.getSunUserNumber());
    }

    @GetMapping("/CountDemand")
    @ApiOperation("需求订单数量统计")
    public ResponseVO getContDemand(){
        return new ResponseVO(dataAnalysisService.getContDemand());
    }

    @GetMapping("/CountDemandProcurement")
    @ApiOperation("采购数量总量统计")
    public ResponseVO contDemandProcurement(){
        return new ResponseVO(dataAnalysisService.contDemandProcurement());
    }

    @GetMapping("/totalvolume")
    @ApiOperation("近十天交易额占比")
    public ResponseVO totalvolume(){
        return new ResponseVO(dataAnalysisService.totalvolume());
    }

    @GetMapping("/aggregateOfAllKindsOfCoal")
    @ApiOperation("折线图")
    public ResponseVO aggregateOfAllKindsOfCoal(){
        return new ResponseVO(dataAnalysisService.aggregateOfAllKindsOfCoal());
    }

    @GetMapping("/modeOfTransportStatistics")
    @ApiOperation("运输方式统计")
    public ResponseVO modeOfTransportStatistics(){
        return new ResponseVO(dataAnalysisService.modeOfTransportStatistics());
    }

    @GetMapping("/regionalCoalDistribution")
    @ApiOperation("地区煤炭分布统计")
    public ResponseVO regionalCoalDistribution(){
        return new ResponseVO(dataAnalysisService.regionalCoalDistribution());
    }

    @GetMapping("/attention")
    @ApiOperation("雷达图")
    public ResponseVO attention(){
        return new ResponseVO(dataAnalysisService.attention());
    }

    @GetMapping("/coalFlowStatistics")
    @ApiOperation("煤炭流向统计")
    public ResponseVO coalFlowStatistics(){
        return new ResponseVO(dataAnalysisService.coalFlowStatistics());
    }

    @GetMapping("/coalDeliveryPlace")
    @ApiOperation("煤炭发货地")
    public ResponseVO coalDeliveryPlace(){
        return new ResponseVO(dataAnalysisService.coalDeliveryPlace());
    }

    @GetMapping("/increase/demandOrder")
    @ApiOperation("新增本周需求订单统计")
    public ResponseVO  getIncreaseDemandOrder(){
        return new ResponseVO(dataAnalysisService.increaseOfDemand());
    }

    @GetMapping("/increase/demandProcurement")
    @ApiOperation("新增本周采购数量统计")
    public ResponseVO  getDemandProcurement(){
        return new ResponseVO(dataAnalysisService.increaseOfDemandProcurement());
    }

    @GetMapping("/increaseTime/sunUser")
    @ApiOperation("最近阳光用户新增时间")
    public ResponseVO getSunUserIncreaseTime(){
        return new ResponseVO(dataAnalysisService.getInsertRecentTime());
    }
}