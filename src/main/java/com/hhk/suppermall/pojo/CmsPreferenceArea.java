package com.hhk.suppermall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
// Serializable 标记序列化对象，告诉jvm对在I/O系统进行持久化序列化对象
@Data
public class CmsPreferenceArea implements Serializable {
    private Long id;
    private String name;
    private String subTitle;
    private Integer sort;
    private Integer showStatus;
    @ApiModelProperty("展示图片")
    private byte[] pic;
    private static final long serialVersionUID = 1L;

}
