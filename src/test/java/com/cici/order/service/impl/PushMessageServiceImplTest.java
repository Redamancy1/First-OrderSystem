package com.cici.order.service.impl;

import com.cici.order.dto.OrderDTO;
import com.cici.order.service.OrderService;
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
class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;

    @Test
    void orderStatus() {

        OrderDTO orderDTO = orderService.findOne("1601277455998196810");
        pushMessageService.orderStatus(orderDTO);
    }
}