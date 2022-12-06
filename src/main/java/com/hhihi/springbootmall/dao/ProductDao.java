package com.hhihi.springbootmall.dao;

import com.hhihi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
