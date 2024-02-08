package com.microproduct.orderservice.dto;

import com.microproduct.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private String orderNumber;
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
