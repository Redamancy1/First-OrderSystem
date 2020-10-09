package com.cici.order.form;

import com.cici.order.enums.ProductStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 前端提交 product 表单
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Integer categoryType;
}
