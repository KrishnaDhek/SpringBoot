package com.programming.productservice;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.programming.productservice.dto.ProductRequest;
import com.programming.productservice.dto.ProductResponse;
import com.programming.productservice.model.Product;
import com.programming.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class ProductServiceApplicationTests {

	// Define a MongoDBContainer to run MongoDB in a Docker container
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	// Autowire the MockMvc instance for making HTTP requests
	@Autowired
	private MockMvc mockMvc;

	// Autowire the ObjectMapper for JSON serialization and deserialization
	@Autowired
	private ObjectMapper objectMapper;

	// Autowire the ProductRepository for database operations
	@Autowired
	private ProductRepository productRepository;

	// Start the MongoDBContainer before any test runs
	static {
		mongoDBContainer.start();
	}

	// Configure dynamic properties to use the MongoDBContainer's connection URL
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	// Integration test for creating a product
	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepository.findAll().size());
	}

	// Helper method to create a ProductRequest object
	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("iPhone 13")
				.description("iPhone 13") // Adjusted description to match the first class
				.price(BigDecimal.valueOf(1200)) // Adjusted price to match the first class
				.build();
	}

	// Integration test for retrieving all products
	@Test
	void shouldReturnProductAllProduct()throws Exception{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

		List<ProductResponse> actualProductList = objectMapper.readValue(mvcResult.getResponse().getContentAsString()
				, new TypeReference<>() {});

		List<Product> productsFromDB =productRepository.findAll();
		Assertions.assertEquals(productsFromDB.size(), actualProductList.size());

		for (int i = 0; i < productsFromDB.size(); i++) {
			ProductResponse actualProduct = actualProductList.get(i);
			Product expectedProduct = productsFromDB.get(i);

			// Perform assertions to compare the attributes of each product
			Assertions.assertEquals(expectedProduct.getId(), actualProduct.getId());
			Assertions.assertEquals(expectedProduct.getName(), actualProduct.getName());
			Assertions.assertEquals(expectedProduct.getDescription(), actualProduct.getDescription());
			Assertions.assertEquals(expectedProduct.getPrice(), actualProduct.getPrice());
		}
	}
}