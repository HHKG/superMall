package com.hhk.suppermall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OmsOrderDetail extends OmsOrder{
    @ApiModelProperty(value = "订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @ApiModelProperty(value = "订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
