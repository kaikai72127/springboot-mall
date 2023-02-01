package com.huangkelly.springbootmall.service;

import java.util.List;

import com.huangkelly.springbootmall.dto.CreateOrderRequest;
import com.huangkelly.springbootmall.dto.OrderQueryParams;
import com.huangkelly.springbootmall.model.Order;

public interface OrderService {
	
	Integer countOrder(OrderQueryParams orderQueryParams);
	
	List<Order> getOrders(OrderQueryParams orderQueryParams); 
	
    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
