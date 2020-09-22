package com.cici.order.enums;

import lombok.Getter;

/**
 * TODO
 *  订单状态枚举
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Getter
public enum OrderStatusEnum {
    New(0,"新订单"),
    FINISHED(1,"完成"),
    CANCEL(2,"已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
