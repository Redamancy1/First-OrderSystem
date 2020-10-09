package com.cici.order.dto;

import com.cici.order.enums.OrderStatusEnum;
import com.cici.order.enums.PayStatusEnum;
import com.cici.order.model.OrderDetail;
import com.cici.order.utils.EnumUtil;
import com.cici.order.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单 DTO 对象
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    //订单id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家手机号码
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信Openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态，默认为0新下单
    private Integer orderStatus;

    //订单支付状态，默认为0未支付
    private Integer payStatus;

    //订单创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //订单更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
