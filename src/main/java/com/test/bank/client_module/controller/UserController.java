package com.test.bank.client_module.controller;

import com.test.bank.client_module.entity.Client;
import com.test.bank.client_module.repo.ClientRepository;
import com.test.bank.client_module.service.ClientService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final ClientService clientService;

    public UserController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

}
