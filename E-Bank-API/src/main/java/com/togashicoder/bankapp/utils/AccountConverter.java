package com.togashicoder.bankapp.utils;

import com.togashicoder.bankapp.dto.AccountDTO;
import com.togashicoder.bankapp.model.Account;
import com.togashicoder.bankapp.model.User;
import com.togashicoder.bankapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    public AccountDTO convertAccountToDto(Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }




    public Account convertDtoToAccount(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        User user = userRepository.findById(accountDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + accountDTO.getUserId()));
        account.setUser(user);
        return account;
    }



    public void updateAccountFromDto(AccountDTO accountDTO, Account account) {
        modelMapper.map(accountDTO, account);
    }
}
