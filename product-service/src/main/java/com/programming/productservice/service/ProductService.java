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
 * Service class for managing product-related business logic.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    /**
     * Creates a new product based on the provided ProductRequest.
     *
     * @param productRequest Request containing product details.
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
     * Retrieves all products and maps them to ProductResponse DTOs.
     *
     * @return List of ProductResponse DTOs.
     */
    public List<ProductResponse> getAllProducts(){
        List<Product> products=productRepository.findAll();
        return  products.stream().map(this::mapToProductResponse).toList();
    }

    /**
     * Maps a Product entity to a ProductResponse DTO.
     *
     * @param product Product entity to be mapped.
     * @return ProductResponse DTO.
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
