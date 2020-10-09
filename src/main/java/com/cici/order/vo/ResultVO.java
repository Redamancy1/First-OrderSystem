package com.cici.order.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求对外的返回的最外层对象
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;


}
