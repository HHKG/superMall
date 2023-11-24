package com.hhk.suppermall.serivice;

import com.hhk.suppermall.pojo.OmsCompanyAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OmsCompanyAddressService {
    /**
     * 获取所有收货地址
     * @return
     */
    List<OmsCompanyAddress> list();
}
