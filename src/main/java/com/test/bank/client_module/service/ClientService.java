package com.test.bank.client_module.service;

import com.test.bank.client_module.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO findClientById(Long id);
    List<ClientDTO> findAllClients();
}
