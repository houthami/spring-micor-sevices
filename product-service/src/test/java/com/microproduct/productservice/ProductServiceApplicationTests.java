package com.microproduct.productservice;

import com.microproduct.productservice.dto.ProductRequest;
import com.microproduct.productservice.repository.ProductRepository;
import com.microproduct.productservice.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}


	@Test
	void createProductTest() throws Exception {
			refreshDb();
			ProductRequest productRequest = getProductResuest();
			String content = objectMapper.writeValueAsString(productRequest);
            mockMvc.perform(MockMvcRequestBuilders
                            .post("/api/product")
							.contentType(MediaType.APPLICATION_JSON)
							.content(content))
					.andExpect(status().isCreated());
        	Assertions.assertEquals(1, productRepository.findAll().size());
    }




	@Test
	void getProductTest() throws Exception {
		refreshDb();
		ProductRequest productRequest = getProductResuest();
		productService.createProduct(productRequest);
		mockMvc.perform(MockMvcRequestBuilders
						.get("/api/product"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(1)));
	}

	private ProductRequest getProductResuest() {
		return ProductRequest.builder()
				.name("iphone")
				.description("this product is for test")
				.price(BigDecimal.valueOf(12000))
				.build();
	}

	private void refreshDb(){
		productRepository.deleteAll();
	}

}
