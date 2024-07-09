package com.togashicoder.bankapp.service.impl;

import com.togashicoder.bankapp.dto.AccountDTO;
import com.togashicoder.bankapp.exception.AccountNotFoundException;
import com.togashicoder.bankapp.model.Account;
import com.togashicoder.bankapp.repository.AccountRepository;
import com.togashicoder.bankapp.service.AccountService;
import com.togashicoder.bankapp.utils.AccountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountConverter.convertDtoToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return accountConverter.convertAccountToDto(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(int accountId) throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));
        return accountConverter.convertAccountToDto(account);
    }

    @Override
    public AccountDTO updateAccount(int accountId, AccountDTO accountDetails) throws AccountNotFoundException {
        Account existingAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));

        accountConverter.updateAccountFromDto(accountDetails, existingAccount);
        Account updatedAccount = accountRepository.save(existingAccount);
        return accountConverter.convertAccountToDto(updatedAccount);
    }

    @Override
    @Transactional
    public void deleteAccount(int accountId) throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found for ID: " + accountId));
        accountRepository.delete(account);
    }


    @Override
    public AccountDTO deposit(int accountId, double amount) throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));
        account.setBalance(account.getBalance() + amount);
        Account updatedAccount = accountRepository.save(account);
        return accountConverter.convertAccountToDto(updatedAccount);
    }

    @Override
    public AccountDTO withdraw(int accountId, double amount) throws AccountNotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        Account updatedAccount = accountRepository.save(account);
        return accountConverter.convertAccountToDto(updatedAccount);
    }

    @Override
    @Transactional
    public void transfer(int sourceAccountId, int targetAccountId, double amount) throws AccountNotFoundException {
        AccountDTO sourceAccountDTO = withdraw(sourceAccountId, amount);
        deposit(targetAccountId, amount);
    }

    @Override
    public List<AccountDTO> getAllAccountsForUser(int userId) {
        List<Account> accounts = accountRepository.findAllByUserId(userId);
        return accounts.stream()
                .map(accountConverter::convertAccountToDto)
                .collect(Collectors.toList());
    }
}
