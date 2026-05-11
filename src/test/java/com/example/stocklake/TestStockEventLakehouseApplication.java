package com.example.stocklake;

import org.springframework.boot.SpringApplication;

public class TestStockEventLakehouseApplication {

	public static void main(String[] args) {
		SpringApplication.from(StockEventLakehouseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
