package com.bank.loans

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.context.config.annotation.RefreshScope

@RefreshScope
@SpringBootApplication
class LoansApplication {

	static void main(String[] args) {
		SpringApplication.run(LoansApplication, args)
	}

}
