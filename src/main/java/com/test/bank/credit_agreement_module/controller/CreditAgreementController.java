package com.test.bank.credit_agreement_module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agreements")
public class CreditAgreementController {

    @GetMapping
    public String agreements(Model model) {
        return "agreements";
    }
}
