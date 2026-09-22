package com.mybank.bank.service;

import com.mybank.bank.model.Card;
import com.mybank.bank.model.User;
import com.mybank.bank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CardService {
    private final Random random = new Random();

    @Autowired
    private UserService userService;
    @Autowired
    private CardRepository cardRepository;

    public Card createCard(Long user_id) {
        User user = userService.getById(user_id);
        Card card = cardRepository.save(new Card(generateNumber(),user, generateCvv()));
        return card;
    }

    public Card findCardByNumber(String number) {
        return cardRepository.findByNumber(number).orElseThrow(() -> new RuntimeException("Карты нет!"));
    }

    private String generateCvv() {
        String number = "";
        while (number.length() < 3) {
            number += Integer.toString(random.nextInt(10));
        }
        return number;
    }


    private String generateNumber() {
        String number = "";
        while (number.length() < 16) {
            number += Integer.toString(random.nextInt(10));
        }
        return number;
    }
}
