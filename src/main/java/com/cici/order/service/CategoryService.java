package com.cici.order.service;

import com.cici.order.model.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * 商品类目功能接口
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface CategoryService {

    Optional<ProductCategory> findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
