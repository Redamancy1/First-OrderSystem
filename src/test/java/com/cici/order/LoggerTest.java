package com.cici.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 * 日志测试
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1(){
        //系统的默认级别是 info，级别在info之上才能显示出来，debug不能
        //logger.debug("debug...");
        //logger.error("error...");
        //logger.info("info...");

        String name = "cici";
        String password = "123456";
        log.debug("debug");
        log.info("name:"+name+",password:"+password);
        log.info("name:{},password:{}",name,password);
        log.error("error");
    }
}
