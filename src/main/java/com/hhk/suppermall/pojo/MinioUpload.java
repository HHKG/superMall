package com.hhk.suppermall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MinioUpload {
    @ApiModelProperty("文件访问URL")
    private String url;
    @ApiModelProperty("文件名称")
    private String name;
}
