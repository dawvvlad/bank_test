package com.test.bank.credit_agreement_module.repo;

import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditAgreementRepositoryImpl implements CreditAgreementRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CreditAgreementRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(CreditAgreement creditAgreement) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(creditAgreement);
    }

    @Override
    public CreditAgreement find(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CreditAgreement.class, id);
    }

    @Override
    public List<CreditAgreement> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from CreditAgreement", CreditAgreement.class)
                .list();
    }
}
