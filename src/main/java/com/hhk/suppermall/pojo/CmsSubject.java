package com.hhk.suppermall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CmsSubject implements Serializable {
    private Long id;
    private Long categoryId;
    private String title;
    @ApiModelProperty(value = "专题主图")
    private String pic;
    @ApiModelProperty(value = "关联产品数量")
    private Integer productCount;
    private Integer recommendStatus;
    private Date createTime;
    private Integer collectCount;
    private Integer readCount;
    private Integer commentCount;
    @ApiModelProperty(value = "画册图片用逗号分割")
    private String albumPics;
    private String description;
    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private String showStatus;
    @ApiModelProperty(value = "转发数")
    private Integer forwardCount;
    @ApiModelProperty(value = "专题分类名称")
    private String categoryName;
    private String content;
    private static final long serialVersionUTD = 1L;

}
