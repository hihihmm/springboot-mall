package com.hhihi.springbootmall.service;

import com.hhihi.springbootmall.dto.ProductRequest;
import com.hhihi.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);
}
