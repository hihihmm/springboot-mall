package com.hihih.springbootmall.dao;

import com.hihih.springbootmall.dto.ProductRequest;
import com.hihih.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);

}