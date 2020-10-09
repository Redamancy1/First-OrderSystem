package com.cici.order.repository;

import com.cici.order.model.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卖家信息repository
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);

}
