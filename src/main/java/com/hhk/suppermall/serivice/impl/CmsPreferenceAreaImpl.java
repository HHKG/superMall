package com.hhk.suppermall.serivice.impl;

import com.hhk.suppermall.mapper.CmsPreferenceAreaMapper;
import com.hhk.suppermall.pojo.CmsPreferenceArea;
import com.hhk.suppermall.pojo.CmsPreferenceAreaExample;
import com.hhk.suppermall.serivice.CmsPreferenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CmsPreferenceAreaImpl implements CmsPreferenceAreaService {
    @Autowired
    private CmsPreferenceAreaMapper cmsPreferenceAreaMapper;
    @Override
    public List<CmsPreferenceArea> listAll() {
        CmsPreferenceAreaExample cmsPreferenceAreaExample = new CmsPreferenceAreaExample();
        return cmsPreferenceAreaMapper.selectByExample(cmsPreferenceAreaExample);
    }
}
