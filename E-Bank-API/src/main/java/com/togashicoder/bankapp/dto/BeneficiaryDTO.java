package com.togashicoder.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BeneficiaryDTO {
    private int id;
    private String name;
    private String rib;
    private String bank; // Enum in real scenario
}
