package com.microproduct.orderservice.repository;

import com.microproduct.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
