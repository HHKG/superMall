package com.hhk.suppermall.serivice.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.mapper.CmsSubjectMapper;
import com.hhk.suppermall.pojo.CmsSubject;
import com.hhk.suppermall.serivice.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;
    @Override
    public List<CmsSubject> listAll() {
        return cmsSubjectMapper.selectAllCmsSubject();
    }

    @Override
    public PageInfo<CmsSubject> list(String keyword, Integer pageNumber, Integer pageSize) {
       PageHelper.startPage(pageNumber,pageSize);
        String TargetStr = keyword;
        if (!StringUtils.isEmpty(keyword)){
            TargetStr="%"+keyword+"%";
        }
        List<CmsSubject> list = cmsSubjectMapper.getListByKeyword(TargetStr);
        PageInfo<CmsSubject> pageUsers = new PageInfo<>(list);
        return pageUsers;
    }
}
