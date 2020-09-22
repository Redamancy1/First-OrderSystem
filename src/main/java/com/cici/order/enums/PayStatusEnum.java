package com.cici.order.enums;

import lombok.Getter;

/**
 * TODO
 *  支付状态枚举
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"待支付"),
    SUCCESS(1,"已支付");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
