package com.bank.cards

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.context.config.annotation.RefreshScope

@RefreshScope
@SpringBootApplication
class CardsApplication {

	static void main(String[] args) {
		SpringApplication.run(CardsApplication, args)
	}

}
