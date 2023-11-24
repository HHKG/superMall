package com.hhk.suppermall.controller;

import com.hhk.suppermall.config.CommonResult;
import com.hhk.suppermall.pojo.OmsCompanyAddress;
import com.hhk.suppermall.serivice.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址管理Controller
 */
@RestController
@Api(tags = "OmsCompanyAddressController")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService omsCompanyAddressService;
    @ApiOperation("获取所有收货地址")
    @GetMapping("/getAllCompanyAddressList")
    public CommonResult<List<OmsCompanyAddress>> list(){
        List<OmsCompanyAddress> list = omsCompanyAddressService.list();
        return CommonResult.success(list);
    }
}
