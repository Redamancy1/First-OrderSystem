package com.cici.order.controller;

import com.cici.order.model.ProductCategory;
import com.cici.order.model.ProductInfo;
import com.cici.order.service.CategoryService;
import com.cici.order.service.ProductService;
import com.cici.order.utils.ResultVOUtil;
import com.cici.order.vo.ProductInfoVO;
import com.cici.order.vo.ProductVO;
import com.cici.order.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *  买家对商品的操作接口
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询商品类目（一次性查询）
        //2.1 通过流的形式将上架商品信息中的 Type 复制给 TypeList
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        //2.2 通过 Type 查询所有对应已上架商品类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼接
        //定义一个商品类目概要信息列表，存储所有符合条件已上架的商品类目
        List<ProductVO> productVOList = new ArrayList<>();
        //3.1 遍历已上架商品类目列表
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            //将已上架商品类目封装到 商品类目概要信息VO
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //3.2 遍历已上架商品信息列表
            for(ProductInfo productInfo:productInfoList){
                //比较商品的 Type 与当前循环的商品类目 Type 是否一致
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //两者一致，将商品信息复制一份到商品详细信息VO
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    //将商品详细信息VO加入已上架商品信息列表
                    productInfoVOList.add(productInfoVO);
                }
            }
            //将拿到的此层商品类目对应的商品信息列表加入到商品类目概要信息VO中
            productVO.setProductInfoVOList(productInfoVOList);
            //将商品类目概要信息VO加入商品类目概要信息VO列表中
            productVOList.add(productVO);
        }
        //通过工具类将最终结果返回给http请求
        return ResultVOUtil.success(productVOList);
    }

}
