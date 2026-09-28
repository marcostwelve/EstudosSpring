package com.example.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("produção", "Homologação");
		//builder.lazyInitialization(true);

		builder.run(args);


		ConfigurableApplicationContext context = builder.context();
		ConfigurableEnvironment environment = context.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");
		System.out.println("Application Name: " + applicationName);

		ExemploValue value = context.getBean(ExemploValue.class);
		value.imprimirVariavel();

		AppProperties context1 = context.getBean(AppProperties.class);

		System.out.println("Valor: " + context1.getValor());
		System.out.println("Variavel: " + context1.getVariavel());


		// SOMENTE EXEMPLOS. NÃO UTILIZAR NESTE FORMATO
		// var produtoRepository = context.getBean("produtoRepository");
		// builder.properties("spring.datasource.url=jdbc:mysql://localhost:3306/arquitetura_spring");

	}

}
