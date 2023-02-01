package com.huangkelly.springbootmall.service;

import com.huangkelly.springbootmall.dto.CreateOrderRequest;
import com.huangkelly.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
