package com.bank.accounts.service

import com.bank.accounts.model.Account
import com.bank.accounts.model.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService {
    @Autowired
    AccountRepository accountRepository

    Account getAccountByCustomerId(String customerId) {
        return accountRepository.findAccountByCustomerId(customerId)
    }

    def saveAccount(Account account) {
        def account1 = accountRepository.save(account)
        account1
    }
}
