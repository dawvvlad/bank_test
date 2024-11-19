package com.test.bank.credit_agreement_module.controller;

import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.service.CreditAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/agreements")
public class CreditAgreementController {

    private final CreditAgreementService creditAgreementService;

    @Autowired
    public CreditAgreementController(CreditAgreementService creditAgreementService) {
        this.creditAgreementService = creditAgreementService;
    }

    @GetMapping
    public String agreements(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "10") int size,
                             Model model) {
        long totalRecords = creditAgreementService.count();
        int totalPages = (int) Math.ceil((double) totalRecords / size);

        model.addAttribute("totalPages", totalPages);

        List<CreditAgreementDTO> creditAgreements = creditAgreementService.findAllPaginated(page, size);

        model.addAttribute("creditAgreements", creditAgreements);
        model.addAttribute("pageSize", size);
        model.addAttribute("currentPage", page);

        return "agreements";
    }
}
