package com.cici.order.service.impl;

import com.cici.order.model.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class SellerServiceImplTest {

    private static final String openid = "abc";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    void findSellerInfoByOpenid() {

        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid,sellerInfo.getOpenid());
    }
}