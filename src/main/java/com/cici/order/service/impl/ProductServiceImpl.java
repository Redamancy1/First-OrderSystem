package com.cici.order.service.impl;

import com.cici.order.dto.CartDTO;
import com.cici.order.enums.ProductStatusEnum;
import com.cici.order.enums.ResultEnum;
import com.cici.order.exception.SellException;
import com.cici.order.model.ProductInfo;
import com.cici.order.repository.ProductInfoRepository;
import com.cici.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * TODO
 *  商品对象功能接口实现类
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public Optional<ProductInfo> findOne(String productId) {
        return repository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            productInfo.orElseThrow(()->new SellException(ResultEnum.PRODUCT_NOT_EXIST));
            Integer result = productInfo.get().getProductStock() + cartDTO.getProductQuantity();
            productInfo.get().setProductStock(result);
            repository.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if(!productInfo.isPresent()){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.get().getProductStock()-cartDTO.getProductQuantity();
            //判断库存是否满足购买数量
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //库存量充足
            productInfo.get().setProductStock(result);
            repository.save(productInfo.get());
        }
    }
}
