package com.microproduct.orderservice.mapping;

import com.microproduct.orderservice.dto.OrderLineItemsDto;
import com.microproduct.orderservice.dto.OrderRequest;
import com.microproduct.orderservice.model.Order;
import com.microproduct.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMapping {

    public OrderLineItems toModel(OrderLineItemsDto orderLineItemsDto){
        return OrderLineItems.builder()
                        .skuCode(orderLineItemsDto.getSkuCode())
                        .price(orderLineItemsDto.getPrice())
                        .quantity(orderLineItemsDto.getQuantity())
                        .build();
    }

    public List<OrderLineItems> toModels(List<OrderLineItemsDto> orderLineItemsDtos){
        return orderLineItemsDtos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
    public Order toModel(OrderRequest orderRequest){
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderLineItemsList(this.toModels(orderRequest.getOrderLineItemsDtoList()))
                .build();
    }
}
