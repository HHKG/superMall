package com.hhk.suppermall.mapper;

import com.hhk.suppermall.pojo.OmsOrder;

import java.util.List;

public interface OmsOrderMapper {
    /**
     * 查询订单
     * @param pageNum
     * @param pageSize
     * @param orderSn
     * @return
     */
    List<OmsOrder> queryOrder(Integer pageNum,Integer pageSize,String orderSn);
}
