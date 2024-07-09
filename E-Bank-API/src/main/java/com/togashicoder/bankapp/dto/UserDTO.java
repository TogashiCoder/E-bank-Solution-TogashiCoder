package com.togashicoder.bankapp.dto;

import com.togashicoder.bankapp.model.Account;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.util.List;
@Data
public class UserDTO {
    private int id;
    @NotBlank(message = "Name is required and cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Phone number is not valid")
    private String phone;

    @NotBlank(message = "City is required and cannot be empty")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;
}