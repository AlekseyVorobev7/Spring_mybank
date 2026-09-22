package com.mybank.bank.controller;

import com.mybank.bank.model.Card;
import com.mybank.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/cards")
public class CardController {
    @Autowired
    private CardService cardService;
    @GetMapping("/{number}")
    public Card getCard(@PathVariable String number) {
        return cardService.findCardByNumber(number);
    }

    @PostMapping("/register")
    public Card createCard(@RequestBody Map<String,String> body) {
        return cardService.createCard(Long.parseLong(body.get("user_id")));
    }
}
