package com.test.bank.credit_application_module.entity;

import com.test.bank.client_module.entity.Client;
import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit_applications")
public class CreditApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "credit_amount")
    private Double amount;

    @Column(name = "approved_sum")
    private Double approvedSum;

    @Column(name = "deadline")
    private int deadline;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToOne(mappedBy = "creditApplication")
    private CreditAgreement creditAgreement;

    public CreditApplication() {};
}
