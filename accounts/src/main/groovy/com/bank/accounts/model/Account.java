package com.bank.accounts.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
public class Account extends BaseEntity {
    String customerId;
    String accountType;
    String accountNumber;
    String accountName;
    String branchAddress;
}
