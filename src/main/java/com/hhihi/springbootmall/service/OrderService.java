package com.hhihi.springbootmall.service;

import com.hhihi.springbootmall.dto.CreateOrderRequest;
import com.hhihi.springbootmall.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    Order getOrderById(Integer orderId);
}
