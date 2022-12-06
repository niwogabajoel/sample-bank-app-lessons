package com.bank.accounts.api

import com.bank.accounts.api.model.Loan
import com.bank.accounts.model.Customer
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "loans", url = "\${feign.url.loans:loans}")
interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "myLoans", consumes = "application/json")
    List<Loan> getLoanDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestBody Customer customer)
}
