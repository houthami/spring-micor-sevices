package com.microproduct.inventoryservice.service;

import com.microproduct.inventoryservice.dto.InventoryResponse;
import com.microproduct.inventoryservice.mapping.InventoryMapping;
import com.microproduct.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapping inventoryMapper;
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return null;
    }
    @Transactional(readOnly = true)
    public Boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
