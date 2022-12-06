package com.bank.accounts.model.repository

import com.bank.accounts.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
