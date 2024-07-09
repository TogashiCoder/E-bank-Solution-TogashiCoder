package com.togashicoder.bankapp.service;

import com.togashicoder.bankapp.dto.AccountDTO;
import com.togashicoder.bankapp.exception.AccountNotFoundException;

import java.util.List;

/**
 * Service interface for managing accounts.
 */
public interface AccountService {

    /**
     * Creates a new account.
     *
     * @param accountDTO the account data transfer object containing account details
     * @return the created account as a data transfer object
     */
    AccountDTO createAccount(AccountDTO accountDTO);

    /**
     * Retrieves an account by its ID.
     *
     * @param accountId the ID of the account to retrieve
     * @return the account as a data transfer object
     * @throws AccountNotFoundException if the account with the specified ID is not found
     */
    AccountDTO getAccountById(int accountId) throws AccountNotFoundException;

    /**
     * Updates an existing account.
     *
     * @param accountId the ID of the account to update
     * @param accountDetails the account data transfer object containing updated account details
     * @return the updated account as a data transfer object
     * @throws AccountNotFoundException if the account with the specified ID is not found
     */
    AccountDTO updateAccount(int accountId, AccountDTO accountDetails) throws AccountNotFoundException;

    /**
     * Deletes an account by its ID.
     *
     * @param accountId the ID of the account to delete
     * @throws AccountNotFoundException if the account with the specified ID is not found
     */
    void deleteAccount(int accountId) throws AccountNotFoundException;

    /**
     * Deposits a specified amount into an account.
     *
     * @param accountId the ID of the account to deposit into
     * @param amount the amount to deposit
     * @return the updated account as a data transfer object
     * @throws AccountNotFoundException if the account with the specified ID is not found
     */
    AccountDTO deposit(int accountId, double amount) throws AccountNotFoundException;

    /**
     * Withdraws a specified amount from an account.
     *
     * @param accountId the ID of the account to withdraw from
     * @param amount the amount to withdraw
     * @return the updated account as a data transfer object
     * @throws AccountNotFoundException if the account with the specified ID is not found
     * @throws IllegalArgumentException if the account does not have sufficient balance
     */
    AccountDTO withdraw(int accountId, double amount) throws AccountNotFoundException;

    /**
     * Transfers a specified amount from one account to another.
     *
     * @param sourceAccountId the ID of the account to transfer from
     * @param targetAccountId the ID of the account to transfer to
     * @param amount the amount to transfer
     * @throws AccountNotFoundException if either the source or target account is not found
     */
    void transfer(int sourceAccountId, int targetAccountId, double amount) throws AccountNotFoundException;

    /**
     * Retrieves all accounts for a specified user.
     *
     * @param userId the ID of the user whose accounts are to be retrieved
     * @return a list of accounts as data transfer objects
     */
    List<AccountDTO> getAllAccountsForUser(int userId);
}
