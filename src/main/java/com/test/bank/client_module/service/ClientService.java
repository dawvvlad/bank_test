package com.test.bank.client_module.service;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.credit_application_module.dto.CreditApplicationDTO;

import java.util.List;

public interface ClientService {
    ClientDTO create(ClientDTO clientDTO);
    ClientDTO findById(Long id);
    List<ClientDTO> findAllPaginated (int page, int size);
    Long count();
    ClientDTO findByPassportOrNumber(String passport, String number);
}
