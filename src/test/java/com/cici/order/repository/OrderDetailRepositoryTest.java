package com.cici.order.repository;

import com.cici.order.model.OrderDetail;
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
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId("123006");
        orderDetail.setProductIcon("http://333.jpg");
        orderDetail.setProductId("12131");
        orderDetail.setProductName("皮卡丘");
        orderDetail.setProductPrice(new BigDecimal(3.6));
        orderDetail.setProductQuantity(3);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }


    @Test
    void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123006");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}