package com.cici.order.enums;

import lombok.Getter;

/**
 * 商品对象状态枚举
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
