package com.hhk.suppermall.serivice.impl;

import com.hhk.suppermall.mapper.OmsOrderItemMapper;
import com.hhk.suppermall.pojo.OmsOrderItem;
import com.hhk.suppermall.serivice.OmsOrderItemService;
import com.hhk.suppermall.serivice.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OmsOrderItemServiceImpl implements OmsOrderItemService {
    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;
    @Override
    public List<OmsOrderItem> list(Long orderId) {
        List<OmsOrderItem> list = omsOrderItemMapper.queryOmsOrderItemByOrderId(orderId);
        return list;
    }
}
