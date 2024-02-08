package com.microproduct.productservice.service;

import com.microproduct.productservice.dto.ProductRequest;
import com.microproduct.productservice.dto.ProductResponse;
import com.microproduct.productservice.mapper.ProductMapper;
import com.microproduct.productservice.model.Product;
import com.microproduct.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = productMapper.toModel(productRequest);
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toResponseList(products);
    }
}
