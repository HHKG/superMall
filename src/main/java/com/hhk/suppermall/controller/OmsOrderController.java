package com.hhk.suppermall.controller;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.config.CommonResult;
import com.hhk.suppermall.pojo.OmsOrder;
import com.hhk.suppermall.serivice.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "OmsOrderController")
@RequestMapping("order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;
    @ApiOperation("查询订单")
    @GetMapping("/getOrderList")
    public CommonResult<PageInfo<OmsOrder>> getOrderList(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                                         @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize,
                                                         @RequestParam(name="orderSn",defaultValue = "",required = false) String orderSn){
        PageInfo<OmsOrder> pageInfo = omsOrderService.queryOrder(pageNum,pageSize,orderSn);
        return CommonResult.success(pageInfo);
    }
}
