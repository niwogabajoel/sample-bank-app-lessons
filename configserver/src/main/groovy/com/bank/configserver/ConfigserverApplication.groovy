package com.bank.configserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigserverApplication {

	static void main(String[] args) {
		SpringApplication.run(ConfigserverApplication, args)
	}

}
