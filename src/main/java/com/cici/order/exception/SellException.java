package com.cici.order.exception;

import com.cici.order.enums.ResultEnum;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
