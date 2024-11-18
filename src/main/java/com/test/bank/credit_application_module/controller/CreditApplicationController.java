package com.test.bank.credit_application_module.controller;

import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import com.test.bank.credit_application_module.service.CreditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/applications")
public class CreditApplicationController {

    private final CreditApplicationService creditApplicationService;

    @Autowired
    public CreditApplicationController(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    @GetMapping
    public String applications(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size,
                               Model model) {

        long totalRecords = creditApplicationService.count();
        int totalPages = (int) Math.ceil((double) totalRecords / size);
        model.addAttribute("totalPages", totalPages);

        List<CreditApplicationDTO> creditApplicationDTOList = creditApplicationService.findAllPaginated(page, size);
        model.addAttribute("credits", creditApplicationDTOList);
        model.addAttribute("pageSize", size);
        model.addAttribute("currentPage", page);

        return "applications";
    }

    @GetMapping("/{id}")
    public String application(@PathVariable Long id, Model model) {
        CreditApplicationDTO creditApplicationDTO = creditApplicationService.findById(id);
        model.addAttribute("creditApplicationDTO", creditApplicationDTO);

        return "application";
    }

    @GetMapping("/new")
    public String newApplication(Model model) {
        return "new_application";
    }
}
