package com.hhk.suppermall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OmsOrderDeliveryParam {
    @ApiModelProperty(value = "订单Id")
    private Long orderId;
    @ApiModelProperty(value = "物流公司")
    private String deliveryCompany;
    @ApiModelProperty(value = "物流单号")
    private String deliverySn;
}
