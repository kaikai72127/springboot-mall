package com.huangkelly.springbootmall.dao;

import com.huangkelly.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}