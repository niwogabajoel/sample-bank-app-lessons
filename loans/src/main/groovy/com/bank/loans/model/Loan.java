package com.bank.loans.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "loan")
@Getter
@Setter
public class Loan extends BaseEntity {
    private String customerId;
    private Date startDate;
    private Date endDate;
    private BigDecimal loanAmount;
    private BigDecimal amountPaid;
    private BigDecimal outStandingAmount;
    private String loanType;
}
