package com.togashicoder.bankapp.service;

import com.togashicoder.bankapp.exception.BankCardException;
import com.togashicoder.bankapp.model.BankCard;

public interface BankCardService {

    // Method to issue a new bank card
    BankCard issueCard(int accountId, BankCard bankCard) throws BankCardException;

    // Method to activate a bank card
    BankCard activateCard(int cardId) throws BankCardException;

    // Method to deactivate a bank card
    BankCard deactivateCard(int cardId) throws BankCardException;

    // Method to block a bank card for reasons such as loss or theft
    BankCard blockCard(int cardId, String reason)throws BankCardException;

    // Method to retrieve a bank card by ID
    BankCard getCardById(int cardId) throws BankCardException;

}
