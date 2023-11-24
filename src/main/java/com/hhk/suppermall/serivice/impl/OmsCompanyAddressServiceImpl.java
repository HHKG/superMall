package com.hhk.suppermall.serivice.impl;

import com.hhk.suppermall.mapper.OmsCompanyAddressMapper;
import com.hhk.suppermall.pojo.OmsCompanyAddress;
import com.hhk.suppermall.serivice.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper omsCompanyAddressMapper;
    /**
     * 获取所有收货地址
     * @return
     */
    @Override
    public List<OmsCompanyAddress> list() {
        List<OmsCompanyAddress> list = omsCompanyAddressMapper.selectAllAddress();
        return list;
    }
}
