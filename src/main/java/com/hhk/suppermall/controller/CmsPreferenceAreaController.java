package com.hhk.suppermall.controller;

import com.hhk.suppermall.config.CommonResult;
import com.hhk.suppermall.pojo.CmsPreferenceArea;
import com.hhk.suppermall.serivice.CmsPreferenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "CmsPreferenceAreaController")
public class CmsPreferenceAreaController {
    @Autowired
    private CmsPreferenceAreaService cmsPreferenceAreaService;
    @ApiOperation("获取所有商品优选")
    @GetMapping("/listAll")
    public CommonResult<List<CmsPreferenceArea>> listAll(){
        List<CmsPreferenceArea> list = cmsPreferenceAreaService.listAll();
        return CommonResult.success(list);
    }
}
