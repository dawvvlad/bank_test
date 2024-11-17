package com.test.bank.client_module.controller;

import com.test.bank.client_module.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String index() {
        System.out.println(clientService.findAll());
        return "index";
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        return "clients";
    }

}
