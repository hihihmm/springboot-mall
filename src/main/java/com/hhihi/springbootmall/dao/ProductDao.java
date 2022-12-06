package com.hhihi.springbootmall.dao;

import com.hhihi.springbootmall.dto.ProductRequest;
import com.hhihi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
