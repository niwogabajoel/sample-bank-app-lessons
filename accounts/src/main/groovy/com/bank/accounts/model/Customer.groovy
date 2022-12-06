package com.bank.accounts.model

import lombok.Getter
import lombok.Setter

import javax.persistence.Entity

@Entity
@Getter
@Setter
class Customer extends BaseEntity{
    String customerId
    String name
    String email
    String phoneNumber
}
