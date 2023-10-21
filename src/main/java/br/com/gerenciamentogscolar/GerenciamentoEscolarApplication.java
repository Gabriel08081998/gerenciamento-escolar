package br.com.gerenciamentogscolar;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableFeignClients
@SpringBootApplication
@ComponentScan
public class GerenciamentoEscolarApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenciamentoEscolarApplication.class, args);
    }

}
