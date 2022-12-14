package com.bank.eurekaserver

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaserverApplication {

	static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication, args)
	}

}
