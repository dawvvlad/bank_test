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
    public void save(CreditApplication creditApplication) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(creditApplication);
    }
}
