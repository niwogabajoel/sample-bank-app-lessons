package com.bank.cards.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "card")
@Data
public class Card extends BaseEntity {

    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

}
