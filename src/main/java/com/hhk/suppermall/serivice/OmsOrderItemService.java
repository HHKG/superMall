package com.hhk.suppermall.serivice;

import com.hhk.suppermall.pojo.OmsOrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OmsOrderItemService {
    /**
     * 根据订单id获取。订单商品列表
     * @param orderId
     * @return
     */
    List<OmsOrderItem> list(Long orderId);
}
