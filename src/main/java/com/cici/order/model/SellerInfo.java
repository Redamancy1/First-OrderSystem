package com.cici.order.model;

/**
 * 卖家信息实体
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
