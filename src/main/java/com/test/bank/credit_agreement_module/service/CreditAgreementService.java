package com.test.bank.credit_agreement_module.service;

import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;

import java.util.List;

public interface CreditAgreementService {
    CreditAgreementDTO findById(Long id);
    CreditAgreementDTO create(CreditAgreementDTO creditAgreementDTO);
    List<CreditAgreementDTO> findAll();
}
