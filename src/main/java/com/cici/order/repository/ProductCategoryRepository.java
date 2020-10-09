package com.cici.order.repository;

import com.cici.order.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目 repository
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
