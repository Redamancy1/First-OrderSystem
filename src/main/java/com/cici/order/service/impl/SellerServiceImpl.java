package com.cici.order.service.impl;

import com.cici.order.model.SellerInfo;
import com.cici.order.repository.SellerInfoRepository;
import com.cici.order.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
