package com.togashicoder.bankapp.dto;

import com.togashicoder.bankapp.model.AccountType;
import com.togashicoder.bankapp.model.Transaction;
import com.togashicoder.bankapp.model.User;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;


@Data
public class AccountDTO {

    private int id;
    @Min(value = 0, message = "Balance cannot be negative")
    private double balance;

    @NotNull(message = "Active status must not be null")
    private Boolean isActive;

    @NotNull(message = "Account type must not be null")
    @Size(min = 1, max = 30, message = "Account type must be between 1 and 30 characters")
    private AccountType accountType; // Enum

    @PastOrPresent(message = "Creation date must be in the past or present")
    private Date creationDate;

    private Date accountClosed;

    @Size(max = 255, message = "Reason for closing must not exceed 255 characters")
    private String reasonForClosing;


    private int userId;
}
