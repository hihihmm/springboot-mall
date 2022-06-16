package com.hihih.springbootmall.dao;

import com.hihih.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

}