package com.microproduct.inventoryservice.repository;

import com.microproduct.inventoryservice.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
