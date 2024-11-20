package com.test.bank.credit_application_module.repo;

import com.test.bank.credit_application_module.entity.CreditApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditApplicationRepositoryImpl implements CreditApplicationRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CreditApplicationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public CreditApplication find(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CreditApplication.class, id);
    }

    @Override
    public List<CreditApplication> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from CreditApplication", CreditApplication.class)
                .list();
    }

    @Override
    public CreditApplication save(CreditApplication creditApplication) {

        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.persist(creditApplication);
            session.getTransaction().commit();
        };

        System.out.println(creditApplication);
        return creditApplication;
    }

    // пагинация
    @Override
    public List<CreditApplication> findAllPaginated(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CreditApplication order by id desc ", CreditApplication.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
    }

    // пагинация
    @Override
    public Long count() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select count(c) from CreditApplication c", Long.class)
                .getSingleResult();
    }
}
