package com.togashicoder.bankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
@Entity
@Table(name = "beneficiaries")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String rib;
    private String bank; // Enum
    @ManyToOne
    @JoinColumn(name = "account_id" ,nullable = false)
    private Account account;
    @OneToMany(mappedBy = "beneficiary",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}