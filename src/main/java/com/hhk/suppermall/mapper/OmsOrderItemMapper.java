package com.hhk.suppermall.mapper;

import com.hhk.suppermall.pojo.OmsOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OmsOrderItemMapper {
    /**
     * 根据orderId查询订单商品列表
     * @param orderId
     * @return
     */
    List<OmsOrderItem> queryOmsOrderItemByOrderId(Long orderId);
}
