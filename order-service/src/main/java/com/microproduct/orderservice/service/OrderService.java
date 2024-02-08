package com.microproduct.orderservice.service;

import com.microproduct.orderservice.dto.OrderRequest;
import com.microproduct.orderservice.mapping.OrderMapping;
import com.microproduct.orderservice.model.Order;
import com.microproduct.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapping orderMapping;
    public String placeOrder(OrderRequest orderRequest) {
        Order order = orderMapping.toModel(orderRequest);
        orderRepository.save(order);
        return order.getOrderNumber();
    }
}
