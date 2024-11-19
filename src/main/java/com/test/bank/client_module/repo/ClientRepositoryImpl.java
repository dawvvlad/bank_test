package com.test.bank.client_module.repo;

import com.test.bank.client_module.dto.ClientDTO;
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
    public Client save(Client client) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Client existingClient = session
                    .createQuery("from Client where passportDetails = :passportDetails", Client.class)
                    .setParameter("passportDetails", client.getPassportDetails())
                    .uniqueResult();

            if (existingClient != null) {
                return existingClient;
            } else {
                session.persist(client);
            }
            session.getTransaction().commit();
        };
            return client;
    };

    @Override
    public List<Client> findAllPaginated(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client order by id desc ", Client.class)
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

    @Override
    public Client findByPassportOrNumber(String passportDetails, String number) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Client where passportDetails = :passportDetails or phoneNumber = :number", Client.class)
                .setParameter("passportDetails", passportDetails)
                .setParameter("number", number)
                .uniqueResult();
    }
}
