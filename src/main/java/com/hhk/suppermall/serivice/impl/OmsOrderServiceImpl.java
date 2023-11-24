package com.hhk.suppermall.serivice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.mapper.OmsOrderMapper;
import com.hhk.suppermall.pojo.OmsOrder;
import com.hhk.suppermall.serivice.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper omsOrderMapper;
    @Override
    public PageInfo<OmsOrder> queryOrder(Integer pageNum, Integer pageSize, String orderSn) {
        PageHelper.startPage(pageNum,pageSize);
        List<OmsOrder> list = omsOrderMapper.queryOrder(pageNum,pageSize,orderSn);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
