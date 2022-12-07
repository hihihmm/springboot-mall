package com.hhihi.springbootmall.service;

import com.hhihi.springbootmall.dto.ProductQueryParams;
import com.hhihi.springbootmall.dto.ProductRequest;
import com.hhihi.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
