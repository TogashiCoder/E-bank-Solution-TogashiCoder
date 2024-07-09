package com.togashicoder.bankapp.repository;

import com.togashicoder.bankapp.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Integer> {
}
