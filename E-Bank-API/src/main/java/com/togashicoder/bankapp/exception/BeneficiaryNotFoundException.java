package com.togashicoder.bankapp.exception;

public class BeneficiaryNotFoundException extends RuntimeException{
    public BeneficiaryNotFoundException(String message) {
        super(message);
    }
}
