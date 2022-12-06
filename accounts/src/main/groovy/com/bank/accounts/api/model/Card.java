package com.bank.accounts.api.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class Card {
    String id;
    private String customerId;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
    @Nullable
    private Date createdDate;
    @Nullable
    private Date lastModifiedDate;

}
