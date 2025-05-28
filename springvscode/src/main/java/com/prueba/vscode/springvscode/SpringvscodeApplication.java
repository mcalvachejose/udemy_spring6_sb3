package com.prueba.vscode.springvscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:values.properties"),
})
public class SpringvscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringvscodeApplication.class, args);
	}

}
