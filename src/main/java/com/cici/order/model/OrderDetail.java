package com.cici.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * TODO
 *  订单详细信息
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;

    private String productIcon;
}
