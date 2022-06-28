package com.hihih.springbootmall.controller;

import com.hihih.springbootmall.constant.ProductCategory;
import com.hihih.springbootmall.dto.ProductQueryParams;
import com.hihih.springbootmall.dto.ProductRequest;
import com.hihih.springbootmall.model.Product;
import com.hihih.springbootmall.service.ProductService;
import com.hihih.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 不管 product 是否為 null，皆回傳 200 OK
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            // 分頁 Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        // 取得 product list (商品列表數據)
        List<Product> prodcutList = productService.getProducts(productQueryParams);

        // 取得 prodcut 總數
        Integer total = productService.countProduct(productQueryParams);

        // 分頁(設定分頁response body 值)
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(prodcutList);


        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    // RestFul 每個
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){

        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        Product product = productService.getProductById(productId);

        // [嚴謹] 先檢查 product 是否存在     (有無檢查皆可)
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 如果存在，修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updateProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    // 刪除商品的意義為「刪除」，前端只需知道商品消失即可(結果)，因此不須檢查ID是否存在
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
