package com.hhk.suppermall.serivice.impl;

import com.hhk.suppermall.mapper.OmsOrderOperateHistoryMapper;
import com.hhk.suppermall.pojo.OmsOrderOperateHistory;
import com.hhk.suppermall.serivice.OmsOrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderOperateHistoryServiceImpl implements OmsOrderOperateHistoryService {
    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;
    @Override
    public List<OmsOrderOperateHistory> list(Long orderId) {
        List<OmsOrderOperateHistory> list = omsOrderOperateHistoryMapper.queryOrderOperateHistoryList(orderId);
        return list;
    }
}
