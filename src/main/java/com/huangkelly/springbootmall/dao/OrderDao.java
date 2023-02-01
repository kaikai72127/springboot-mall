package com.huangkelly.springbootmall.dao;

import com.huangkelly.springbootmall.dto.OrderQueryParams;
import com.huangkelly.springbootmall.model.Order;
import com.huangkelly.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
	
	Integer countOrder(OrderQueryParams orderQueryParams);
	
	List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);
    
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId,Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

}
