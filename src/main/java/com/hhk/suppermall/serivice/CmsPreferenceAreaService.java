package com.hhk.suppermall.serivice;

import com.hhk.suppermall.pojo.CmsPreferenceArea;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CmsPreferenceAreaService {
    List<CmsPreferenceArea> listAll();
}
