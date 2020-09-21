package com.cici.order.enums;

import lombok.Getter;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"ON-SALE"),
    DOWN(1,"NO-SALE");

    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
