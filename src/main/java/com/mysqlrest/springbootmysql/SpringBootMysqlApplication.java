package com.mysqlrest.springbootmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.mysqlrest.springbootmysql")
@EntityScan(basePackages = "com.mysqlrest.springbootmysql.models")
public class SpringBootMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlApplication.class, args);
	}

//---COMANDOS PARA INICIAR DOCKER---
//mvn clean install (cria/atualiza jar)
//docker-compose up --build --force-recreate (Inicia o docker, builda o Dockerfile e força a recriação para atualização no docker)

}
