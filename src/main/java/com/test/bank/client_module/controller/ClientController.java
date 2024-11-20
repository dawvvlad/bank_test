package com.test.bank.client_module.controller;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String getClientsPage(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "15") int size,
                                 @RequestParam(required = false) String query,
                                 Model model) {
        List<ClientDTO> clients;

        if (query != null && !query.trim().isEmpty()) {
            clients = clientService.search(query.trim());
            model.addAttribute("searchQuery", query);
        } else {
            long totalRecords = clientService.count();
            int totalPages = (int) Math.ceil((double) totalRecords / size);
            model.addAttribute("totalPages", totalPages);

            clients = clientService.findAllPaginated(page, size);
            model.addAttribute("pageSize", size);
            model.addAttribute("currentPage", page);
        }

        model.addAttribute("clients", clients);
        return "clients";
    }


    @GetMapping("/{id}")
    public String client(Model model, @PathVariable Long id) {
        model.addAttribute("client", clientService.findById(id));
        return "client";
    }

    @PostMapping
    public String createClient(@ModelAttribute ClientDTO clientDTO, Model model) {
        model.addAttribute("client", clientDTO);
        clientService.create(clientDTO);
        System.out.println("Client created");
        return "redirect:/clients";
    }

}
