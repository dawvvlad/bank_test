package com.test.bank.credit_application_module.dto;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.credit_application_module.entity.CreditApplication;
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
    private LocalDateTime createdAt;

    public CreditApplicationDTO() {}

    public CreditApplicationDTO(Long id, Boolean isApproved, ClientDTO client, Double amount, Double approvedSum, Integer deadline, LocalDateTime createdAt) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.approvedSum = approvedSum;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.isApproved = isApproved;
    }

    public CreditApplicationDTO(CreditApplication creditApplication) {
        this.id = creditApplication.getId();
        this.client = new ClientDTO(creditApplication.getClient());
        this.amount = creditApplication.getAmount();
        this.approvedSum = creditApplication.getApprovedSum();
        this.deadline = creditApplication.getDeadline();
        this.createdAt = creditApplication.getDate();
        this.isApproved = creditApplication.getIsApproved();
    }
}
