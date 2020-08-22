package com.xzm.medicineapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzm.medicineapp.mapper")
public class MedicineappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicineappApplication.class, args);
	}

}
