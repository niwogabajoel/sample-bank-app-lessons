package com.bank.cards.service

import com.bank.cards.model.Card
import com.bank.cards.model.repository.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CardService {
    @Autowired
    private CardRepository cardRepository

    List<Card> findByCustomerId(String customerId) {
        cardRepository.findByCustomerId(customerId)
    }

    Card addCard(Card card) {
        cardRepository.save(card)
    }
}
