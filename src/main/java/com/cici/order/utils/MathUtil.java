package com.cici.order.utils;

/**
 * 金额判断工具类
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public class MathUtil {

    //判断金额是否相等
    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1 - d2);
        if(result < 0.01){
            return true;
        }else {
            return false;
        }
    }
}
