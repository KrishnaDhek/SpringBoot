package com.programming.productservice.controller;

import com.programming.productservice.dto.ProductRequest;
import com.programming.productservice.dto.ProductResponse;
import com.programming.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Endpoint to create a new product.
     *
     * @param productRequest The request containing product information.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }

    /**
     * Endpoint to retrieve all products.
     *
     * @return List of ProductResponse containing product information.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }



}
