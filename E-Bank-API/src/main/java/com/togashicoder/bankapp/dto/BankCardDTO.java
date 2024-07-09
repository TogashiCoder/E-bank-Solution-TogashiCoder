package com.togashicoder.bankapp.dto;

import com.togashicoder.bankapp.model.Status;
import com.togashicoder.bankapp.model.Type;
import lombok.Data;

import java.util.Date;
@Data
public class BankCardDTO {
    private int id;
    private String cardNumber;
    private Date expirationDate;
    private Type cardType; // Enum
    private Status status; // Enum
    private String blockReason;
}
