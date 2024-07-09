package com.togashicoder.bankapp.repository;

import com.togashicoder.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    List<Account> findAllByUserId(int userId);

}