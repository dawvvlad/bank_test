package com.test.bank.credit_application_module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applications")
public class CreditApplicationController {

    @GetMapping
    public String index(Model model) {
        return "index";
    }
}
