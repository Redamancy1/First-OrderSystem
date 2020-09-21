package com.cici.order.service.impl;

import com.cici.order.model.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findById(){
        Optional<ProductCategory> productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.get().getCategoryId());

    }

    @Test
    public void findAll(){
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,productCategoryList.size());

    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory("少儿专享",7);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }

}