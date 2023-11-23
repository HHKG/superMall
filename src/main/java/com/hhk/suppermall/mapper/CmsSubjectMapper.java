package com.hhk.suppermall.mapper;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.pojo.CmsSubject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsSubjectMapper {
    List<CmsSubject> selectAllCmsSubject();
    List<CmsSubject> getListByKeyword(String keyword);
}
