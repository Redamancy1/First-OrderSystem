package com.cici.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 前端提交 order 数据表单
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "微信openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
