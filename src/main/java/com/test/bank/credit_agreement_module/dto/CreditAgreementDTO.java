package com.test.bank.credit_agreement_module.dto;

import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.enums.AgreementStatus;
import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreditAgreementDTO {
    private Long id;
    private CreditApplicationDTO application;
    private LocalDateTime signDate;
    private AgreementStatus agreementStatus;

    public CreditAgreementDTO() {}

    public CreditAgreementDTO(CreditAgreement creditAgreement) {
        this.id = creditAgreement.getId();
        this.agreementStatus = creditAgreement.getStatus();
        this.signDate = creditAgreement.getSignDate();
        this.application = creditAgreement.getCreditApplication() == null ?
                null :
                new CreditApplicationDTO(creditAgreement.getCreditApplication());
    }
}
