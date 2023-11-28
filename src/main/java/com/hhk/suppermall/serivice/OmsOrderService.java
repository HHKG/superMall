package com.hhk.suppermall.serivice;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.pojo.OmsOrder;
import com.hhk.suppermall.pojo.OmsOrderDeliveryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OmsOrderService {
    /**
     * 查询订单
     * @param pageNum
     * @param pageSize
     * @param orderSn
     * @return
     */
    PageInfo<OmsOrder> queryOrder(Integer pageNum, Integer pageSize, String orderSn);

    /**
     * 批量发货
     * @param deliveryParamList
     * @return
     */
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     * @param ids
     * @param note
     * @return
     */
    int close(List<Long> ids,String note);

    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    int delete(List<Long> ids);

    /**
     * 根据orderId查询订单信息
     * @param orderId
     * @return
     */
    OmsOrder queryOrderById(Long orderId);
}
