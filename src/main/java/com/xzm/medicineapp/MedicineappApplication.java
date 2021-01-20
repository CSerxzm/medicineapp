package com.xzm.medicineapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.xzm.medicineapp.mapper")
@EnableCaching
public class MedicineappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineappApplication.class, args);
	}

}
