package com.togashicoder.bankapp.service;

import com.togashicoder.bankapp.exception.BeneficiaryNotFoundException;
import com.togashicoder.bankapp.model.Beneficiary;

import java.util.List;

public interface BeneficiaryService {
    // Method to add a new beneficiary
    Beneficiary addBeneficiary(Beneficiary beneficiary);

    // Method to retrieve a beneficiary by ID
    Beneficiary getBeneficiaryById(int beneficiaryId) throws BeneficiaryNotFoundException;

    // Method to update beneficiary details
    Beneficiary updateBeneficiary(int beneficiaryId, Beneficiary beneficiaryDetails) throws BeneficiaryNotFoundException;

    // Method to delete a beneficiary
    void deleteBeneficiary(int beneficiaryId) throws BeneficiaryNotFoundException;

    // Method to list all beneficiaries for a specific user
    List<Beneficiary> getAllBeneficiariesForUser(int userId);
}
