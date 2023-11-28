package com.hhk.suppermall.serivice;

import com.hhk.suppermall.pojo.OmsOrderOperateHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OmsOrderOperateHistoryService {
    /**
     * 根据orderId获取订单操作记录
     * @param orderId
     * @return
     */
    List<OmsOrderOperateHistory> list(Long orderId);
}
