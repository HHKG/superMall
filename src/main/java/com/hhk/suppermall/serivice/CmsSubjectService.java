package com.hhk.suppermall.serivice;

import com.github.pagehelper.PageInfo;
import com.hhk.suppermall.pojo.CmsSubject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CmsSubjectService {
    /**
     * 查询所有专题
     * @return
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     * @param keyword
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<CmsSubject> list(String keyword, Integer pageNumber, Integer pageSize);
}
