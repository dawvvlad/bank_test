package com.test.bank.credit_application_module.entity;

import com.test.bank.client_module.entity.Client;
import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import com.test.bank.credit_application_module.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit_applications")
@Data
public class CreditApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "credit_amount")
    private Double amount;

    @Column(name = "approved_sum")
    private Double approvedSum;

    @Column(name = "deadline")
    private int deadline;

    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @OneToOne(mappedBy = "creditApplication")
    private CreditAgreement creditAgreement;

    public CreditApplication() {};

    public CreditApplication(CreditApplicationDTO creditApplicationDTO) {
        this.id = creditApplicationDTO.getId();
        this.amount = creditApplicationDTO.getAmount();
        this.approvedSum = creditApplicationDTO.getApprovedSum();
        this.date = creditApplicationDTO.getCreatedAt();
        this.isApproved = creditApplicationDTO.getIsApproved();
        this.deadline = creditApplicationDTO.getDeadline();
        this.status = creditApplicationDTO.getStatus();
    }
}
