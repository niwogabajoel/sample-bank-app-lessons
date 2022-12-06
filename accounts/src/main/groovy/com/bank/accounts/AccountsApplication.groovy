package com.bank.accounts

import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@EnableFeignClients
@RefreshScope
@SpringBootApplication
class AccountsApplication {

	static void main(String[] args) {
		SpringApplication.run(AccountsApplication, args)
	}

	@Bean
	TimedAspect timedAspect(MeterRegistry meterRegistry){
		return new TimedAspect()
	}

}
