package com.huangkelly.springbootmall.service.impl;

import com.huangkelly.springbootmall.dao.OrderDao;
import com.huangkelly.springbootmall.dao.ProductDao;
import com.huangkelly.springbootmall.dto.BuyItem;
import com.huangkelly.springbootmall.dto.CreateOrderRequest;
import com.huangkelly.springbootmall.model.Order;
import com.huangkelly.springbootmall.model.OrderItem;
import com.huangkelly.springbootmall.model.Product;
import com.huangkelly.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
       int totalAmount =0;
       List<OrderItem> orderItemList = new ArrayList<>();

       for(BuyItem buyItem:createOrderRequest.getBuyItemList()){
           Product product = productDao.getProductById(buyItem.getProductId());

           //計算總價錢
           int amount = buyItem.getQuantity()*product.getPrice();
           totalAmount =totalAmount+amount;

           //轉換BuyItem to OrderItem
           OrderItem orderItem = new OrderItem();
           orderItem.setProductId(buyItem.getProductId());
           orderItem.setQuantity(buyItem.getQuantity());
           orderItem.setAmount(amount);

           orderItemList.add(orderItem);
       }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId,totalAmount);

        orderDao.createOrderItems(orderId,orderItemList);

        return orderId;
    }
}
