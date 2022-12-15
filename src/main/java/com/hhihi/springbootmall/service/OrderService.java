package com.hhihi.springbootmall.service;

import com.hhihi.springbootmall.dto.CreateOrderRequest;
import com.hhihi.springbootmall.dto.OrderQueryParams;
import com.hhihi.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);
    List<Order> getOrders(OrderQueryParams orderQueryParams);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    Order getOrderById(Integer orderId);
}
