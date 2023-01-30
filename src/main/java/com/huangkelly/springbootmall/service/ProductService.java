package com.huangkelly.springbootmall.service;

import com.huangkelly.springbootmall.constant.ProductCategory;
import com.huangkelly.springbootmall.dto.ProductRequest;
import com.huangkelly.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void  updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
