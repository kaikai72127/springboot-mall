package com.huangkelly.springbootmall.controller;

import com.huangkelly.springbootmall.constant.ProductCategory;
import com.huangkelly.springbootmall.dto.ProductQueryParams;
import com.huangkelly.springbootmall.dto.ProductRequest;
import com.huangkelly.springbootmall.model.Product;
import com.huangkelly.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    
    
    

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
    		@RequestParam(required = false) ProductCategory category,
    		@RequestParam(required = false) String search
    		
    		){
    	ProductQueryParams productQueryParams = new ProductQueryParams();
    	productQueryParams.setCategory(category);
    	productQueryParams.setSearch(search);
    	
    	
        List<Product> productList = productService.getProducts(productQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }



    //查詢商品的功能
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //新增商品的功能
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid  ProductRequest productRequest){

        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);

    }


    //修改商品的功能
    @PutMapping ("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        //檢查商品是否存在
        Product product = productService.getProductById(productId);

        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //如果存在 修改商品的數據
        productService.updateProduct(productId,productRequest);
        Product updateProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    //刪除商品的功能
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
