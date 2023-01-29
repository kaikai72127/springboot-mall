package com.huangkelly.springbootmall.service;

import com.huangkelly.springbootmall.dto.ProductRequest;
import com.huangkelly.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void  updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
