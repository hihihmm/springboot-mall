package com.hihih.springbootmall.service;

import com.hihih.springbootmall.dto.ProductQueryParams;
import com.hihih.springbootmall.dto.ProductRequest;
import com.hihih.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
