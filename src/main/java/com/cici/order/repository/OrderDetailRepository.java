package com.cici.order.repository;

import com.cici.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情 repository
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    //一张订单主表可以对应多笔订单详情
   List<OrderDetail> findByOrderId(String orderId);

}
