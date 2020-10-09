package com.cici.order.constant;

/**
 * redis 常量
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface RedisConstant {

    /**
     * 设置前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间
     */
    Integer EXPIRE = 7200;
}
