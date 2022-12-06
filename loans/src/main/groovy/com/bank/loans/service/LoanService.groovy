package com.bank.loans.service

import com.bank.loans.model.Customer
import com.bank.loans.model.Loan
import com.bank.loans.model.repository.LoanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanService {
    @Autowired
    LoanRepository loanRepository


    List<Loan> findByCustomerIdOrderByStartDtDesc(String customerId) {
        loanRepository.findByCustomerIdOrderByStartDateDesc(customerId)
    }

    def addNewLoan(Loan loan) {
        loanRepository.save(loan)
    }
}
