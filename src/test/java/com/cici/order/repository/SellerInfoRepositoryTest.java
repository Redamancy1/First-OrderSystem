package com.cici.order.repository;

import com.cici.order.model.SellerInfo;
import com.cici.order.utils.KeyUtil;
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
class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.CreateKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOpenid(){
        SellerInfo result = repository.findByOpenid("abc");
        Assert.assertEquals("abc",result.getOpenid());

    }


}