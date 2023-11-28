package com.hhk.suppermall.serivice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.mapper.OmsOrderMapper;
import com.hhk.suppermall.mapper.OmsOrderOperateHistoryMapper;
import com.hhk.suppermall.pojo.OmsOrder;
import com.hhk.suppermall.pojo.OmsOrderDeliveryParam;
import com.hhk.suppermall.pojo.OmsOrderOperateHistory;
import com.hhk.suppermall.serivice.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;
    @Override
    public PageInfo<OmsOrder> queryOrder(Integer pageNum, Integer pageSize, String orderSn) {
        PageHelper.startPage(pageNum,pageSize);
        List<OmsOrder> list = omsOrderMapper.queryOrder(pageNum,pageSize,orderSn);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        // 批量发货
        int count = omsOrderMapper.updateOrder(deliveryParamList);
        // 添加操作记录
        List<OmsOrderOperateHistory> list = deliveryParamList.stream().map(item->{
            OmsOrderOperateHistory omsOrderOperateHistory = new OmsOrderOperateHistory();
            omsOrderOperateHistory.setOrderId(item.getOrderId());
            omsOrderOperateHistory.setOperateMan("后台管理员");
            omsOrderOperateHistory.setCreateTime(new Date());
            omsOrderOperateHistory.setNote("完成发货");
            omsOrderOperateHistory.setOrderStatus(2);
            return omsOrderOperateHistory;
        }).collect(Collectors.toList());
        omsOrderOperateHistoryMapper.insertList(list);
        return count;
    }

    @Override
    public int close(List<Long> ids, String note) {
        int count = omsOrderMapper.closeOrder(ids,note);
        List<OmsOrderOperateHistory> list = ids.stream().map(orderId->{
            OmsOrderOperateHistory omsOrderOperateHistory = new OmsOrderOperateHistory();
            omsOrderOperateHistory.setOrderStatus(4);
            omsOrderOperateHistory.setOrderId(orderId);
            omsOrderOperateHistory.setCreateTime(new Date());
            omsOrderOperateHistory.setNote("订单关闭："+ note);
            omsOrderOperateHistory.setOperateMan("后台管理员");
            return omsOrderOperateHistory;
        }).collect(Collectors.toList());
        omsOrderOperateHistoryMapper.insertList(list);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        int count = omsOrderMapper.deleteOrderByOrderId(ids);
        return count;
    }

    @Override
    public OmsOrder queryOrderById(Long orderId) {
        OmsOrder omsOrder = omsOrderMapper.queryOrderByOrderId(orderId);
        return omsOrder;
    }
}
