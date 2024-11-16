package com.test.bank.client_module.service;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.repo.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public ClientDTO createClient(ClientDTO clientDTO) {
        return clientDTO;
    }

    @Override
    public ClientDTO findClientById(Long id) {
        return null;
    }

    @Override
    public List<ClientDTO> findAllClients() {
        return List.of();
    }
}
