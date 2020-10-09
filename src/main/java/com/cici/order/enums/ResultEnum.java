package com.cici.order.enums;

import lombok.Getter;

/**
 * 请求返回结果枚举
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
    PARAM_ERROR(1000,"参数不正确"),
   PRODUCT_NOT_EXIST(1001,"商品不存在"),
   PRODUCT_STOCK_ERROR(1002,"商品库存不正确"),
    ORDER_NOT_EXIST(1003,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(1004,"订单详情不存在"),
    ORDER_STATUS_ERROR(1005,"订单状态不正确"),
    ORDER_UPDATE_FAIL(1006,"订单更新失败"),
    ORDER_DETAIL_EMPTY(1007,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(1008,"订单支付状态不正确"),
    CART_EMPTY(1009,"购物车为空"),
    ORDER_OWNER_ERROR(1020,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(1021,"微信公众号方面错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(1022,"微信支付异常通知金额校验不通过"),
    ORDER_CANCEL_SUCCESS(1023,"订单取消成功"),
    ORDER_FINISH_SUCCESS(1024, "订单完结成功"),

    PRODUCT_STATUS_ERROR(1025, "商品状态不正确"),

    LOGIN_FAIL(1026, "登录失败, 登录信息不正确"),

    LOGOUT_SUCCESS(1027, "登出成功"),
    ;


    private Integer code;
    private String message;

    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
