package com.cici.order.vo;

import lombok.Data;

/**
 * TODO
 * http请求对外的返回的最外层对象
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;


}
