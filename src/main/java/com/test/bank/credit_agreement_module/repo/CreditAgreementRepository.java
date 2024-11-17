package com.test.bank.credit_agreement_module.repo;

import com.test.bank.credit_agreement_module.entity.CreditAgreement;

import java.util.List;

public interface CreditAgreementRepository {
    void save(CreditAgreement creditAgreement);
    CreditAgreement find(Long id);
    List<CreditAgreement> findAll();
}
