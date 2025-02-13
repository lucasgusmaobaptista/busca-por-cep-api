package com.lucasgusmao.busca_por_cep_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BuscaPorCepApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscaPorCepApiApplication.class, args);
	}

}
