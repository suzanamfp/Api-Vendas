package com.br.demo.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication 
@EnableAutoConfiguration
@EntityScan(value = {"com.br.demo.model.entity"})
@EnableJpaRepositories(basePackages = {"com.br.demo.repositorys"})
@ComponentScan        (basePackages = {"com.br.demo.controller", "com.br.demo.service.impl", "com.br.demo.config"})
public class VendasApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
		
		
	}
	
	
}
