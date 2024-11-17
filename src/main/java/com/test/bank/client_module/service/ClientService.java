package com.test.bank.client_module.service;

import com.test.bank.client_module.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO create(ClientDTO clientDTO);
    ClientDTO findById(Long id);
    List<ClientDTO> findAll();
}
