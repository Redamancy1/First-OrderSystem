package com.cici.order.service.impl;

import com.cici.order.dto.OrderDTO;
import com.cici.order.service.OrderService;
import com.cici.order.service.PayService;
import lombok.extern.slf4j.Slf4j;
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
class PayServiceImplTest {


    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    void create() {
        //该订单号测试时已支付过，仅用来测试查看信息如openid
        //最新测试用订单号：123000
        OrderDTO orderDTO = orderService.findOne("12121212");
        payService.create(orderDTO);
    }

    @Test
    public void refund(){
        OrderDTO orderDTO = orderService.findOne("1600787000098184871");
        payService.refund(orderDTO);
    }
}