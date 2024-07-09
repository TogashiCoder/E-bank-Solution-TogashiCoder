package com.togashicoder.bankapp.controller;

import com.togashicoder.bankapp.dto.AccountDTO;
import com.togashicoder.bankapp.exception.AccountNotFoundException;
import com.togashicoder.bankapp.exception.UserNotFoundException;
import com.togashicoder.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        // The accountDTO includes the userId.
        AccountDTO createdAccount = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable int accountId) {
        try {
            AccountDTO accountDTO = accountService.getAccountById(accountId);
            return ResponseEntity.ok(accountDTO);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable int accountId, @RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO updatedAccount = accountService.updateAccount(accountId, accountDTO);
            return ResponseEntity.ok(updatedAccount);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int accountId) {
        try {
            accountService.deleteAccount(accountId);
            return ResponseEntity.ok().build();
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/deposit/{accountId}")
    public ResponseEntity<AccountDTO> deposit(@PathVariable int accountId, @RequestParam double amount) {
        try {
            AccountDTO updatedAccount = accountService.deposit(accountId, amount);
            return ResponseEntity.ok(updatedAccount);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/withdraw/{accountId}")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable int accountId, @RequestParam double amount) {
        try {
            AccountDTO updatedAccount = accountService.withdraw(accountId, amount);
            return ResponseEntity.ok(updatedAccount);
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestParam int sourceAccountId, @RequestParam int targetAccountId, @RequestParam double amount) {
        try {
            accountService.transfer(sourceAccountId, targetAccountId, amount);
            return ResponseEntity.ok().build();
        } catch (AccountNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccountDTO>> getAllAccountsForUser(@PathVariable int userId) {
        List<AccountDTO> accounts = accountService.getAllAccountsForUser(userId);
        return ResponseEntity.ok(accounts);
    }
}
