package com.cici.order.service;

import com.cici.order.model.SellerInfo;

/**
 * 商家功能接口
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
