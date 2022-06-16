package com.hihih.springbootmall.service.impl;

import com.hihih.springbootmall.dao.ProductDao;
import com.hihih.springbootmall.model.Product;
import com.hihih.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
