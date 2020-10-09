package com.cici.order.utils;

import com.cici.order.enums.CodeEnum;

/**
 * 枚举工具类
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
