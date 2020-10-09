package com.cici.order.model.mapper;

import com.cici.order.model.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    void insertByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","New Type");
        map.put("category_type",101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(101);
        Assert.assertNotNull(productCategory);
    }
}