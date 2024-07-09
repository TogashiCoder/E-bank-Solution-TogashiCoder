package com.togashicoder.bankapp.service;

import com.togashicoder.bankapp.exception.TransactionException;
import com.togashicoder.bankapp.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(int transactionId) throws TransactionException;

    List<Transaction> getAllTransactionsForAccount(int accountId);

}
