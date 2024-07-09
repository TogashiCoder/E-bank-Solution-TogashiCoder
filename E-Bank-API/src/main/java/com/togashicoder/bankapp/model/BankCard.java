package com.togashicoder.bankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
@Entity
@Table(name = "bank_cards")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardNumber;
    private Date expirationDate;
    @Enumerated(EnumType.STRING)
    private Type cardType;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String blockReason;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;


}
