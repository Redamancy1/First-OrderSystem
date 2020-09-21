package com.cici.order.repository;

import com.cici.order.model.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
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
class ProductCategoryRepositoryTest {


    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        Optional<ProductCategory> pro = repository.findById(1);
        System.out.println(pro.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory pro = new ProductCategory();
        pro.setCategoryName("游戏周边");
        pro.setCategoryType(5);
        repository.save(pro);
    }

    @Test
    public void update(){
        Optional<ProductCategory> pro = repository.findById(6);
        System.out.println(pro.toString());
//        pro.ifPresent(a -> {
//            a.setCategoryType(10);
//        });
        pro.ifPresent(productCategory -> productCategory.setCategoryType(8));
        repository.save(pro.get());
        System.out.println(pro.toString());
    }

    @Test
    @Transactional
    public void saveTest2(){
        ProductCategory pro = new ProductCategory("新品",7);
        ProductCategory result = repository.save(pro);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }


}