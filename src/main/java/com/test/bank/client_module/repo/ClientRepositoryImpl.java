package com.test.bank.client_module.repo;

import com.test.bank.client_module.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;
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
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try(session) {
            //проверка, существует ли клиент
            Client existingClient = session
                    .createQuery("from Client where passportDetails = :passportDetails", Client.class)
                    .setParameter("passportDetails", client.getPassportDetails())
                    .uniqueResult();


            // если да - вернуть существующего клиента
            if (existingClient != null) {
                return existingClient;
            } else { // иначе - сохранить в базу нового
                session.persist(client);
            }
            transaction.commit();
        } catch (TransactionException e) {
            transaction.rollback();
        }
            return client;
    };


    // пагинация
    @Override
    public List<Client> findAllPaginated(int page, int size) {
        Session session = sessionFactory.getCurrentSession();

        // возвращает заданное количество клиентов
        return session.createQuery("from Client order by id desc ", Client.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
    }

    // подсчет количества клиентов
    @Override
    public Long count() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select count(c) from Client c", Long.class)
                .getSingleResult();
    }


    // поиск по паспорту или номеру для проверки на уникальность в контроллере
    @Override
    public Client findByPassportOrNumber(String passportDetails, String number) {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Client where passportDetails = :passportDetails or phoneNumber = :number", Client.class)
                .setParameter("passportDetails", passportDetails)
                .setParameter("number", number)
                .uniqueResult();
    }


    // поиск клиента
    @Override
    public List<Client> search(String queryStr) {
        Session session = sessionFactory.getCurrentSession();

        // запрос - соответствие одного из 5 параметров
        String hql = "FROM Client c WHERE " +
                "LOWER(c.firstName) LIKE :query OR " +
                "LOWER(c.lastName) LIKE :query OR " +
                "LOWER(c.middleName) LIKE :query OR " +
                "c.phoneNumber LIKE :query OR " +
                "c.passportDetails LIKE :query";

        Query<Client> query = session.createQuery(hql, Client.class);

        // добавление % для соответствующих строк
        query.setParameter("query", "%" + queryStr.toLowerCase() + "%");
        return query.list();
    }


}
