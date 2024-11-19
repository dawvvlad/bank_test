package com.test.bank.core.controller;

import com.test.bank.client_module.controller.ClientController;
import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.entity.Client;
import com.test.bank.client_module.service.ClientService;
import com.test.bank.core.service.DecisionProcessor;
import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.enums.AgreementStatus;
import com.test.bank.credit_agreement_module.service.CreditAgreementService;
import com.test.bank.credit_application_module.controller.CreditApplicationController;
import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import com.test.bank.credit_application_module.enums.ApplicationStatus;
import com.test.bank.credit_application_module.service.CreditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("gateway")
public class GatewayController {

    private final ClientController clientController;
    private final CreditApplicationController creditApplicationController;
    private final ClientService clientService;
    private final CreditApplicationService creditApplicationService;
    private final CreditAgreementService creditAgreementService;

    @Autowired
    public GatewayController(ClientController clientController,
                             CreditApplicationController creditApplicationController,
                             ClientService clientService,
                             CreditApplicationService creditApplicationService,
                             CreditAgreementService creditAgreementService) {
        this.clientController = clientController;
        this.creditApplicationController = creditApplicationController;
        this.clientService = clientService;
        this.creditApplicationService = creditApplicationService;
        this.creditAgreementService = creditAgreementService;
    }

    @GetMapping("/new")
    public String newGateway() {
        return "new_application";
    }

    @PostMapping("/new")
    public String createUserAndApplication(ClientDTO clientDTO,
                                           CreditApplicationDTO creditApplicationDTO,
                                           Model model) {
        try {
            DecisionProcessor decisionProcessor = new DecisionProcessor();
            boolean isApproved = false;

            Thread.sleep(1000);

            double approvedSum = decisionProcessor.makeDecision(creditApplicationDTO.getAmount());

            System.out.println(approvedSum);

            if(approvedSum != -1) {
                isApproved = true;
                // Credit Application DTO
                creditApplicationDTO.setApprovedSum(approvedSum);
                creditApplicationDTO.setStatus(ApplicationStatus.approved);
            } else {
                creditApplicationDTO.setStatus(ApplicationStatus.not_approved);
                creditApplicationDTO.setApprovedSum(0d);
            }
            creditApplicationDTO.setIsApproved(isApproved);
            creditApplicationDTO.setClient(clientDTO);

            // Credit Agreement DTO
            if(isApproved) {
                CreditAgreementDTO creditAgreementDTO = new CreditAgreementDTO();
                creditAgreementDTO.setAgreementStatus(AgreementStatus.not_signed);
                creditAgreementDTO.setSignDate(LocalDateTime.now());
                creditAgreementDTO.setApplication(creditApplicationDTO);
                creditAgreementService.create(creditAgreementDTO);

                return "redirect:/sign_agreement";
            } else {
                creditApplicationService.create(creditApplicationDTO);
            }
            model.addAttribute("client", clientDTO);
            model.addAttribute("creditApplication", creditApplicationDTO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "redirect:/clients";
    }
}
