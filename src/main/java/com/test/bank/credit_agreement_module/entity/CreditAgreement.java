package com.test.bank.credit_agreement_module.entity;

import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
import com.test.bank.credit_agreement_module.enums.AgreementStatus;
import com.test.bank.credit_application_module.entity.CreditApplication;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "agreements")
@Data
public class CreditAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "credit_app_id")
    private CreditApplication creditApplication;

    @Column(name = "sign_date")
    private LocalDateTime signDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AgreementStatus status;

    public CreditAgreement(){};
    public CreditAgreement(CreditAgreementDTO creditAgreementDTO) {
        this.creditApplication = new CreditApplication(creditAgreementDTO.getApplication());
        this.signDate = LocalDateTime.now();
        this.status = creditAgreementDTO.getAgreementStatus();
    }

}
