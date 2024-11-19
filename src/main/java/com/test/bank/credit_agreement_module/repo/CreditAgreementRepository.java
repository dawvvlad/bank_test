package com.test.bank.credit_agreement_module.repo;

import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.enums.AgreementStatus;

import java.util.List;

public interface CreditAgreementRepository {
    void updateAgreementStatus(Long id, AgreementStatus agreementStatus);

    CreditAgreement save(CreditAgreement creditAgreement);
    CreditAgreement find(Long id);
    List<CreditAgreement> findAll();
    List<CreditAgreement> findAllPaginated(int page, int pageSize);
    long count();
}
