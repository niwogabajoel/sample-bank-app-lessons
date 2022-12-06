package com.bank.accounts.model.repository;

import com.bank.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    Account findAccountById(String id);
    Account findAccountByCustomerId(String customerId);
}
