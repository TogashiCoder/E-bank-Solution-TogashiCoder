package com.togashicoder.bankapp.repository;

import com.togashicoder.bankapp.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardBankRepository extends JpaRepository<BankCard,Integer> {
}
