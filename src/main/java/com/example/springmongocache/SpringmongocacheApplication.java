package com.example.springmongocache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.demo.dao") 
@ComponentScan("com.example.*")
@EnableCaching
public class SpringmongocacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongocacheApplication.class, args);
	}

}
