package com.hhk.suppermall.mapper;

import com.hhk.suppermall.pojo.OmsOrder;
import com.hhk.suppermall.pojo.OmsOrderDeliveryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OmsOrderMapper {
    /**
     * 查询订单
     * @param pageNum
     * @param pageSize
     * @param orderSn
     * @return
     */
    List<OmsOrder> queryOrder(Integer pageNum,Integer pageSize,String orderSn);

    /**
     * 批量发货
     * @param deliveryParamList
     * @return
     */
    int updateOrder(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     * @param ids
     * @param note
     * @return
     */
    int closeOrder(List<Long> ids,String note);

    /**
     * 批量删除订单
     * @param orderIds
     * @return
     */
    int deleteOrderByOrderId(List<Long> orderIds);

    /**
     * 根据orderId查询订单信息
     * @param orderId
     * @return
     */
    OmsOrder queryOrderByOrderId(Long orderId);
}
