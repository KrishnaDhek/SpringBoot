package com.programming.productservice.service;

import com.programming.productservice.dto.ProductRequest;
import com.programming.productservice.dto.ProductResponse;
import com.programming.productservice.model.Product;
import com.programming.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing products.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    /**
     * Adds a new product to the database.
     * @param productRequest The request containing details of the product to be added.
     */
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

    }

    /**
     * Retrieves all products from the database and maps them to ProductResponse objects.
     * @return List of ProductResponse containing details of all products.
     */
    public List<ProductResponse> getAllProduct(){
       List<Product> products= productRepository.findAll();

       return products.stream().map(this::mapToProductResponse).toList();
    }

    /**
     * Maps a Product entity to a ProductResponse DTO.
     * @param product The Product entity to map.
     * @return ProductResponse DTO containing details of the product.
     */
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
