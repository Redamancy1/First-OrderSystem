package com.cici.order.utils;

import java.util.Random;

/**
 * 随机生成号码工具类
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return 返回生成的号码
     */
    public static synchronized String CreateKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }




}
