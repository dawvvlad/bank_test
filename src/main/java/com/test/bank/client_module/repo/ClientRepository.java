package com.test.bank.client_module.repo;

import com.test.bank.client_module.entity.Client;
import com.test.bank.credit_application_module.entity.CreditApplication;

import java.util.List;

public interface ClientRepository {
    Client find(Long id);
    List<Client> findAll();
    Client save(Client client);
    List<Client> findAllPaginated(int page, int size);
    Long count();
}
