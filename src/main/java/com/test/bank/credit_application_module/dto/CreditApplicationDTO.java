package com.test.bank.credit_application_module.dto;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.credit_application_module.entity.CreditApplication;
import com.test.bank.credit_application_module.enums.ApplicationStatus;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CreditApplicationDTO {
    private Long id;
    private ClientDTO client;
    private Boolean isApproved;
    private Double amount;
    private Double approvedSum;
    private Integer deadline;
    private LocalDateTime createdAt = LocalDateTime.now();
    private ApplicationStatus status;
    private Long agreementNumber = null;

    public CreditApplicationDTO() {}

    public CreditApplicationDTO(Long id, Boolean isApproved, ClientDTO client, Double amount, Double approvedSum, Integer deadline, LocalDateTime createdAt, ApplicationStatus status, Long agreementNumber) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.approvedSum = approvedSum;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.isApproved = isApproved;
        this.status = status;
        this.agreementNumber = agreementNumber;
    }

    public CreditApplicationDTO(CreditApplication creditApplication) {
        this.id = creditApplication.getId();
        this.client = new ClientDTO(creditApplication.getClient());
        this.amount = creditApplication.getAmount();
        this.approvedSum = creditApplication.getApprovedSum();
        this.deadline = creditApplication.getDeadline();
        this.createdAt = creditApplication.getDate();
        this.isApproved = creditApplication.getIsApproved();
        this.status = creditApplication.getStatus();
        this.agreementNumber = (creditApplication.getCreditAgreement() == null ?
                null :
                creditApplication.getCreditAgreement().getId());
    }
}
