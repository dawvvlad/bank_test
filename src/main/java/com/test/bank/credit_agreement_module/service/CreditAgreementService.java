package com.test.bank.credit_agreement_module.service;

import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
import com.test.bank.credit_agreement_module.enums.AgreementStatus;

import java.util.List;

public interface CreditAgreementService {
    void updateCreditAgreementStatus(Long id, AgreementStatus status);
    CreditAgreementDTO findById(Long id);
    CreditAgreementDTO create(CreditAgreementDTO creditAgreementDTO);
    List<CreditAgreementDTO> findAllPaginated(int page, int size);
    long count();
}
