package com.cici.order.dto;

import lombok.Data;

/**
 * 购物车 DTO 对象
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
public class CartDTO {

    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
