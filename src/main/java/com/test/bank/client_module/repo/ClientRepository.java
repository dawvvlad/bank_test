package com.test.bank.client_module.repo;

import com.test.bank.client_module.entity.Client;
import java.util.List;

public interface ClientRepository {
    Client find(Long id);
    List<Client> findAll();
    void save(Client client);
}
