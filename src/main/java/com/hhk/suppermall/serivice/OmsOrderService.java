package com.hhk.suppermall.serivice;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.pojo.OmsOrder;
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
}
