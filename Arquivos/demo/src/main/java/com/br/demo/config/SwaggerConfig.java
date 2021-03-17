package com.br.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket detalheApi() {
		return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.br.demo"))
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(this.informacoesApi().build());
	}
	
	

	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Api-Estado");
		apiInfoBuilder.description("Api para realização de um CRUD.");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Usando para estudos.");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("https://github.com/suzanamfp");
		apiInfoBuilder.contact(this.contato());
 
		return apiInfoBuilder;
 
	}
	

	private Contact contato() {
	
		return new Contact(
				"Suzana Freitas",
				"https://github.com/suzanamfp",
				"suzanamfp.29@gmail.com");
	}
	
	//http://localhost:8080/swagger-ui.html
}
