package com.cici.order.repository;

import com.cici.order.model.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO
 *  商品主表测试
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;



    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("kiki");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("仲恺官网");
        orderMaster.setBuyerOpenid("110112");
        orderMaster.setOrderAmount(new BigDecimal(5.7));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    void findByBuyerOpenid() {
        //PageRequesst 继承 AbstractPageRequest -> 实现 Pageable
        PageRequest request = PageRequest.of(0,1);
        Page<OrderMaster> result = repository.findByBuyerOpenid("110110",request);
        Assert.assertNotEquals(0,result.getTotalElements());
        System.out.println(result.getTotalElements());
    }
}