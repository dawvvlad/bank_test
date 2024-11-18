package com.test.bank.client_module.repo;

import com.test.bank.client_module.entity.Client;
import com.test.bank.credit_application_module.entity.CreditApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public ClientRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Client find(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client", Client.class).list();
    }

    @Override
    public void save(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
    }

    @Override
    public List<Client> findAllPaginated(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client", Client.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
    }

    @Override
    public Long count() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select count(c) from Client c", Long.class)
                .getSingleResult();
    }
}
