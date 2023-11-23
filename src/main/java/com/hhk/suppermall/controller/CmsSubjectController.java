package com.hhk.suppermall.controller;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.config.CommonResult;
import com.hhk.suppermall.pojo.CmsSubject;
import com.hhk.suppermall.serivice.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "CmsSubjectController")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService cmsSubjectService;
    @ApiOperation("获取全部商品专题")
    @GetMapping("/listAll")
    public CommonResult<List<CmsSubject>> listAll(){
        List<CmsSubject> list = cmsSubjectService.listAll();
        return CommonResult.success(list);
    }
    @ApiOperation(value = "根据专题名称分页获取商品专题")
    @GetMapping("/getListByKeyword")
    public CommonResult<PageInfo<CmsSubject>> list(@RequestParam(value = "keyword",required = false) String keyword,
                                               @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize){
        PageInfo<CmsSubject> list = cmsSubjectService.list(keyword,pageNum,pageSize);
        return CommonResult.success(list);

    }
}
