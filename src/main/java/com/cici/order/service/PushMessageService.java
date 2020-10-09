package com.cici.order.service;

import com.cici.order.dto.OrderDTO;

/**
 * 推送消息接口
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     */
    void orderStatus(OrderDTO orderDTO);
}
