package com.test.bank.credit_agreement_module.entity;

import com.test.bank.credit_application_module.entity.CreditApplication;
import jakarta.persistence.*;
import lombok.Data;

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

    public CreditAgreement(){};
}
