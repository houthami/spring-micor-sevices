package com.microproduct.inventoryservice.mapping;
import com.microproduct.inventoryservice.dto.InventoryResponse;
import com.microproduct.inventoryservice.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapping {
    public Inventory toModel(InventoryResponse inventoryResponse){
        return Inventory.builder()
                .id(inventoryResponse.getId())
                .skuCode(inventoryResponse.getSkuCode())
                .quantity(inventoryResponse.getQuantity())
                .build();
    }
}
