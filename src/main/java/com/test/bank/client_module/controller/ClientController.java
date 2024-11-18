package com.test.bank.client_module.controller;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String clients(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int size,
                          Model model) {

        long totalRecords = clientService.count();
        int totalPages = (int) Math.ceil((double) totalRecords / size);
        model.addAttribute("totalPages", totalPages);

        List<ClientDTO> clientDTOS = clientService.findAllPaginated(page, size);
        model.addAttribute("clients", clientDTOS);
        model.addAttribute("pageSize", size);
        model.addAttribute("currentPage", page);

        return "clients";
    }

    @GetMapping("/clients/{id}")
    public String client(Model model, @PathVariable Long id) {
        model.addAttribute("client", clientService.findById(id));
        return "client";
    }

    @PostMapping("/clients")
    public String createClient(@ModelAttribute ClientDTO clientDTO, Model model) {
        model.addAttribute("client", clientDTO);
        clientService.create(clientDTO);
        System.out.println("Client created");
        return "redirect:/clients";
    }

}
