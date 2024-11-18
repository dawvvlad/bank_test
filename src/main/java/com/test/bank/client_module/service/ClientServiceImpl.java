package com.test.bank.client_module.service;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.entity.Client;
import com.test.bank.client_module.repo.ClientRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO create(ClientDTO clientDTO) {
        Client client = new Client(clientDTO);
        clientRepository.save(client);
        return clientDTO;
    }

    @Override
    public ClientDTO findById(Long id) {
        Client client = clientRepository.find(id);
        if(client == null) {
            return null;
        }
        return new ClientDTO(client);
    }

    @Override
    public List<ClientDTO> findAll() {
//        List<Client> clients = clientRepository.findAll();
//        List<ClientDTO> clientDTOS = new ArrayList<>();
//
//        if(clients == null) {
//            return Collections.emptyList();
//        }
//
//        for (Client client : clients) {
//            clientDTOS.add(new ClientDTO(client));
//        }

        return List.of();
    }

    @Override
    public List<ClientDTO> findAllPaginated(int page, int size) {
        List<Client> clients = clientRepository.findAllPaginated(page, size);
        List<ClientDTO> clientDTOS = new ArrayList<>();
        if(clients == null) {
            return Collections.emptyList();
        }

        for (Client client : clients) {
            clientDTOS.add(new ClientDTO(client));
        }

        return clientDTOS;
    }

    @Override
    public Long count() {
        return clientRepository.count();
    }
}
