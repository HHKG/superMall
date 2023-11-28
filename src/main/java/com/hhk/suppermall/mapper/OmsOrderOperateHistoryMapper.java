package com.hhk.suppermall.mapper;

import com.hhk.suppermall.pojo.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OmsOrderOperateHistoryMapper {
    /**
     * 批量创建
     * @param omsOrderOperateHistoryList
     * @return
     */
    int insertList(@Param("list")List<OmsOrderOperateHistory> omsOrderOperateHistoryList);

    /**
     * 根据orderId查询订单记录
     * @param orderId
     * @return
     */
    List<OmsOrderOperateHistory> queryOrderOperateHistoryList(Long orderId);
}
