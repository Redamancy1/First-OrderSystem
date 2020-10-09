package com.cici.order.form;

import lombok.Data;

/**
 * 前端提交 category 表单
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}

