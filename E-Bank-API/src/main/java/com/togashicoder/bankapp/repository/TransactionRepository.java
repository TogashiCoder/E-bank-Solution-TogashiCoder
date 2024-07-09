package com.togashicoder.bankapp.repository;

import com.togashicoder.bankapp.model.Account;
import com.togashicoder.bankapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction,Integer> {
}
