package br.com.leangua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CapitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalApplication.class, args);
	}

}
