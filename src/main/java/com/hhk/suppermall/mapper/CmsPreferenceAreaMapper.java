package com.hhk.suppermall.mapper;

import com.hhk.suppermall.pojo.CmsPreferenceArea;
import com.hhk.suppermall.pojo.CmsPreferenceAreaExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsPreferenceAreaMapper {
    List<CmsPreferenceArea> selectByExample(CmsPreferenceAreaExample example);
}
