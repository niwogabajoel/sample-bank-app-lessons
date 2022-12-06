package com.bank.cards.controller

import com.bank.cards.model.Card
import com.bank.cards.model.Customer
import com.bank.cards.service.CardService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class CardController {

    private static final Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService cardService

    @PostMapping("/myCards")
    List<Card> getCardDetails(@RequestHeader("eazybank-correlation-id") String correlationId, @RequestBody Customer customer) {
        logger.info("Started getLoansDetails() correlationId {}.",correlationId)
        List<Card> cards = cardService.findByCustomerId(customer.customerId)
        if (cards != null) {
            return cards
        } else {
            return null
        }
    }

    @PostMapping("/")
    Card addCard(@RequestBody Card card) {
        Card cards = cardService.addCard(card)
        if (cards != null) {
            return cards
        } else {
            return null
        }
    }


}
