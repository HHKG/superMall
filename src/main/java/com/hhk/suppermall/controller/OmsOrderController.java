package com.hhk.suppermall.controller;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.config.CommonResult;
import com.hhk.suppermall.pojo.*;
import com.hhk.suppermall.serivice.OmsOrderItemService;
import com.hhk.suppermall.serivice.OmsOrderOperateHistoryService;
import com.hhk.suppermall.serivice.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "OmsOrderController")
@RequestMapping("order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;
    @Autowired
    private OmsOrderItemService omsOrderItemService;
    @Autowired
    private OmsOrderOperateHistoryService omsOrderOperateHistoryService;
    @ApiOperation("查询订单")
    @GetMapping("/getOrderList")
    public CommonResult<PageInfo<OmsOrder>> getOrderList(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                                         @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize,
                                                         @RequestParam(name="orderSn",defaultValue = "",required = false) String orderSn){
        PageInfo<OmsOrder> pageInfo = omsOrderService.queryOrder(pageNum,pageSize,orderSn);
        return CommonResult.success(pageInfo);
    }
    @ApiOperation(value = "批量发货")
    @PostMapping("/delivery")
    public CommonResult delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList){
        int count = omsOrderService.delivery(deliveryParamList);
        if(count>0){
            return CommonResult.success(count,"发货成功！");
        }
        return CommonResult.failed();

    }
    @ApiOperation(value = "批量关闭订单")
    @PostMapping("/closeOrder")
    public CommonResult closeOrder(@RequestParam("ids") List<Long> ids,@RequestParam String note){
        int count = omsOrderService.close(ids,note);
        if(count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "批量删除订单")
    @PostMapping("/delete")
    public CommonResult deleteOrder(@RequestParam("orderIds") List<Long> orderIds){
        int count = omsOrderService.delete(orderIds);
        if(count > 0){
            return CommonResult.success(count,"删除成功！");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "获取订单详情：订单信息、商品信息、操作记录")
    @GetMapping("/getOrderDetail/{id}")
    public CommonResult<OmsOrderDetail> getOrderDetail(@PathVariable("id") Long id){
        OmsOrderDetail omsOrderDetail = new OmsOrderDetail();
        // 根据订单id查询订单表数据
        OmsOrder omsOrder = omsOrderService.queryOrderById(id);
        // 根据订单，查询订单商品列表，一个订单对多个商品
        List<OmsOrderItem> orderItemList = omsOrderItemService.list((id));
        // 根据订单，查询订单操作记录
        List<OmsOrderOperateHistory> historyList = omsOrderOperateHistoryService.list(id);
        omsOrderDetail.setOrderItemList(orderItemList);
        omsOrderDetail.setHistoryList(historyList);
        omsOrderDetail.setOrderSn(omsOrder.getOrderSn());
        omsOrderDetail.setOrderType(omsOrder.getOrderType());
        omsOrderDetail.setAutoConfirmDay(omsOrder.getAutoConfirmDay());
        omsOrderDetail.setBillContent(omsOrder.getBillContent());
        omsOrderDetail.setBillHeader(omsOrder.getBillHeader());
        omsOrderDetail.setBillReceiverEmail(omsOrder.getBillReceiverEmail());
        omsOrderDetail.setBillReceiverPhone(omsOrder.getBillReceiverPhone());
        omsOrderDetail.setCommentTime(omsOrder.getCommentTime());
        omsOrderDetail.setConfirmStatus(omsOrder.getConfirmStatus());
        omsOrderDetail.setCouponAmount(omsOrder.getCouponAmount());
        omsOrderDetail.setCouponId(omsOrder.getCouponId());
        omsOrderDetail.setCreateTime(omsOrder.getCreateTime());
        omsOrderDetail.setDeleteStatus(omsOrder.getDeleteStatus());
        omsOrderDetail.setDeliveryCompany(omsOrder.getDeliveryCompany());
        omsOrderDetail.setDeliverySn(omsOrder.getDeliverySn());
        omsOrderDetail.setDeliveryTime(omsOrder.getDeliveryTime());
        omsOrderDetail.setUseIntegration(omsOrder.getUseIntegration());
        omsOrderDetail.setStatus(omsOrder.getStatus());
        omsOrderDetail.setTotalAmount(omsOrder.getTotalAmount());
        omsOrderDetail.setSourceType(omsOrder.getSourceType());
        omsOrderDetail.setReceiveTime(omsOrder.getReceiveTime());
        omsOrderDetail.setReceiverRegion(omsOrder.getReceiverRegion());
        omsOrderDetail.setReceiverProvince(omsOrder.getReceiverProvince());
        omsOrderDetail.setReceiverPostCode(omsOrder.getReceiverPostCode());
        omsOrderDetail.setReceiverPhone(omsOrder.getReceiverPhone());
        omsOrderDetail.setReceiverName(omsOrder.getReceiverName());
        omsOrderDetail.setReceiverDetailAddress(omsOrder.getReceiverDetailAddress());
        omsOrderDetail.setReceiverCity(omsOrder.getReceiverCity());
        omsOrderDetail.setPromotionInfo(omsOrder.getPromotionInfo());
        omsOrderDetail.setPromotionAmount(omsOrder.getPromotionAmount());
        omsOrderDetail.setPayType(omsOrder.getPayType());
        omsOrderDetail.setPaymentTime(omsOrder.getPaymentTime());
        omsOrderDetail.setPayAmount(omsOrder.getPayAmount());
        omsOrderDetail.setNote(omsOrder.getNote());
        omsOrderDetail.setModifyTime(omsOrder.getModifyTime());
        omsOrderDetail.setMemberUsername(omsOrder.getMemberUsername());
        omsOrderDetail.setMemberId(omsOrder.getMemberId());
        omsOrderDetail.setIntegrationAmount(omsOrder.getIntegrationAmount());
        omsOrderDetail.setGrowth(omsOrder.getGrowth());
        omsOrderDetail.setFreightAmount(omsOrder.getFreightAmount());
        omsOrderDetail.setDiscountAmount(omsOrder.getDiscountAmount());
        omsOrderDetail.setBillType(omsOrder.getBillType());
        return CommonResult.success(omsOrderDetail);
    }


}
