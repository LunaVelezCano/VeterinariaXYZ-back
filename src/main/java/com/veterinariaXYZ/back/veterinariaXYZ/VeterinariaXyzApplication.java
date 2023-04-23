package com.veterinariaXYZ.back.veterinariaXYZ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan
@EnableCaching

public class VeterinariaXyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaXyzApplication.class, args);
	}

}


