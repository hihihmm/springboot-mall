package com.hhihi.springbootmall.dao;

import com.hhihi.springbootmall.dto.CreateOrderRequest;
import com.hhihi.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
