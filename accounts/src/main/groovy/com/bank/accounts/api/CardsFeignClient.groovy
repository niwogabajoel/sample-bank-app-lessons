package com.bank.accounts.api

import com.bank.accounts.model.Customer
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import com.bank.accounts.api.model.Card
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient( name = "cards", url = "\${feign.url.cards:cards}")
interface CardsFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "myCards", consumes = "application/json")
    List<Card> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestBody Customer customer)
}
