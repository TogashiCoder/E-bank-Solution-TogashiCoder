package com.togashicoder.bankapp.dto;

import com.togashicoder.bankapp.model.Account;
import com.togashicoder.bankapp.model.TransactionType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
public class TransactionDTO {
    private int id;
    private Date date;
    private double amount;
    private TransactionType transactionType; // Enum
    private String description;
    private Account account;
}
