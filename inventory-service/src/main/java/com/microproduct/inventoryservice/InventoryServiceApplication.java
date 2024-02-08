package com.microproduct.inventoryservice;

import com.microproduct.inventoryservice.model.Inventory;
import com.microproduct.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = Inventory.builder()
					.skuCode("a4ffdx5s")
					.quantity(12)
					.build();
			Inventory inventory1 = Inventory.builder()
					.skuCode("a4fffrddx5s")
					.quantity(0)
					.build();
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
