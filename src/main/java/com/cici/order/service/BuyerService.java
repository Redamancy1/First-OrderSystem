package com.cici.order.service;

import com.cici.order.dto.OrderDTO;

/**
 * TODO
 *  用于完善用户查询、取消订单时的权限验证接口
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);

}
