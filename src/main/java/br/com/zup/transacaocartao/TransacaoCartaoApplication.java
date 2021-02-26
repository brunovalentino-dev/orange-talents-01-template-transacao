package br.com.zup.transacaocartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransacaoCartaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransacaoCartaoApplication.class, args);
	}

}
