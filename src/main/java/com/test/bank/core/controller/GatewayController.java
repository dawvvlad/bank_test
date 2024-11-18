package com.test.bank.core.controller;

import com.test.bank.client_module.controller.ClientController;
import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.credit_application_module.controller.CreditApplicationController;
import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gateway")
public class GatewayController {
    private final ClientController clientController;
    private final CreditApplicationController creditApplicationController;

    @Autowired
    public GatewayController(ClientController clientController, CreditApplicationController creditApplicationController) {
        this.clientController = clientController;
        this.creditApplicationController = creditApplicationController;
    }

    @PostMapping("/create")
    public String createUserAndApplication(ClientDTO clientDTO,
                                           CreditApplicationDTO creditApplicationDTO,
                                           Model model) {

        return "redirect:/applications";
    }
}
