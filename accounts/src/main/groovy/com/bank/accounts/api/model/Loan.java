package com.bank.accounts.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Loan {
    String id;
    private String customerId;
    private Date startDate;
    private Date endDate;
    private BigDecimal loanAmount;
    private BigDecimal amountPaid;
    private BigDecimal outStandingAmount;
    private String loanType;
    @Nullable
    private Date createdDate;
    @Nullable
    private Date lastModifiedDate;
}
