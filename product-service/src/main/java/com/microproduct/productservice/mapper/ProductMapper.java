package com.microproduct.productservice.mapper;

import com.microproduct.productservice.dto.ProductRequest;
import com.microproduct.productservice.dto.ProductResponse;
import com.microproduct.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product toModel(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }

    public Product toModel(ProductResponse productResponse){
        return Product.builder()
                .id(productResponse.getId())
                .name(productResponse.getName())
                .description(productResponse.getDescription())
                .price(productResponse.getPrice())
                .build();
    }

    public ProductResponse toResponce(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public List<ProductResponse> toResponseList(List<Product> products) {
        return products.stream()
                .map(this::toResponce)
                .collect(Collectors.toList());
    }
}
