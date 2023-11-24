package com.hhk.suppermall.mapper;

import com.hhk.suppermall.pojo.OmsCompanyAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OmsCompanyAddressMapper {
    List<OmsCompanyAddress> selectAllAddress();
}
