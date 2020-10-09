package com.cici.order.repository;

import com.cici.order.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表信息 repository
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
