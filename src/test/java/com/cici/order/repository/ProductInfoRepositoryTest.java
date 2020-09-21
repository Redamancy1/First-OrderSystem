package com.cici.order.repository;

import com.cici.order.model.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123455");
        productInfo.setProductName("ggqq");
        productInfo.setProductPrice(new BigDecimal(4.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("wow~so cool");
        productInfo.setProductIcon("http://www.cici.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus(){
        //0为正常状态
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());

    }


}