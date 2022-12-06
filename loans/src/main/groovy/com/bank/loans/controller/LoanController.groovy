package com.bank.loans.controller

import com.bank.loans.model.Customer
import com.bank.loans.model.Loan
import com.bank.loans.service.LoanService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class LoanController {

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService

    @PostMapping("/myLoans")
    List<Loan> getLoansDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestBody Customer customer) {
        logger.debug("Invoking loans micro-service")
        List<Loan> loans = loanService.findByCustomerIdOrderByStartDtDesc(customer.customerId)
        logger.info("getLoansDetails() correlationId {}.",correlationId)

        if (loans != null) {
            return loans
        } else {
            return null
        }
    }

    @PostMapping("/")
    Loan addLoan(@RequestBody Loan loan) {
        Loan loan1 = loanService.addNewLoan(loan)
        if (loan1 != null) {
            return loan1
        } else {
            return null
        }
    }
}
