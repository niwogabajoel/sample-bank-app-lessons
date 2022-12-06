package com.bank.accounts.controller

import com.bank.accounts.api.CardsFeignClient
import com.bank.accounts.api.LoansFeignClient
import com.bank.accounts.model.Account
import com.bank.accounts.model.Customer
import com.bank.accounts.service.AccountService
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import io.github.resilience4j.retry.annotation.Retry
import io.micrometer.core.annotation.Timed
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService
    @Autowired
    CardsFeignClient cardsFeignClient
    @Autowired
    LoansFeignClient loansFeignClient

    @GetMapping("/customer/{customerId}")
    @Timed(value = "accountDetails.time",description = "Time taken to return account details")
    Account getMyAccount(@PathVariable("customerId") String customerId) {
        def customerAcc = accountService.getAccountByCustomerId(customerId)
        return customerAcc
    }


    @PostMapping("/")
    Account addAccount(@RequestBody Account account) {
        println(account)
        account.setCreatedDate(new Date())
        return accountService.saveAccount(account)
    }

    @PostMapping("/myCustomerDetails")
    @CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod = "fallbackCustomerDetails")
    @Retry(name = "retryCustomerCustomerDetails",fallbackMethod = "fallbackCustomerDetails")
    def customerDetails(@RequestHeader("xonixbank-correlation-id") String correlationId, @RequestBody Customer customer) {
        logger.info("Started getLoansDetails() correlationId {}.",correlationId)

        def account = accountService.getAccountByCustomerId(customer.getCustomerId())
        def loans = loansFeignClient.getLoanDetails(correlationId, customer)
        def cards = cardsFeignClient.getCardDetails(correlationId, customer)
        logger.info("Finished getLoansDetails() correlationId {}.",correlationId)

        def map = [
                loans  : loans,
                cards  : cards,
                account: account
        ]

        return map
    }

    private def fallbackCustomerDetails(@RequestHeader("xonixbank-correlation-id") String correlationId, Customer customer,Throwable t) {
        logger.info("Used fallbackCustomerDetails() correlationId {}.",correlationId)

        def account = accountService.getAccountByCustomerId(customer.getCustomerId())
        def loans = loansFeignClient.getLoanDetails(correlationId,customer)
        def map = [
                loans  : loans,
                cards  : [],
                account: account
        ]

        return map
    }

    @GetMapping("/sayHello")
    @RateLimiter(name = "sayHello",fallbackMethod = "sayHelloFallBack")
    def sayHello(){
        logger.info("Called sayHello().")
        return "Hello, welcome XONIX Bank"
    }

    private def sayHelloFallBack(Throwable t){
        logger.info("Called sayHelloFallBack().")
        return "Hi, welcome XONIX Bank"
    }

}
