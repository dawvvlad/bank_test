package com.test.bank.credit_agreement_module.repo;

import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.enums.AgreementStatus;
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
    public void updateAgreementStatus(Long id, AgreementStatus agreementStatus) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CreditAgreement creditAgreement = session.get(CreditAgreement.class, id);
            creditAgreement.setStatus(agreementStatus);
            session.getTransaction().commit();
        }
    }

    @Override
    public CreditAgreement save(CreditAgreement creditAgreement) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(creditAgreement);
            session.getTransaction().commit();
        }
        return creditAgreement;
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


    // пагинация
    @Override
    public List<CreditAgreement> findAllPaginated(int page, int size) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CreditAgreement order by id desc ", CreditAgreement.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
    }

    @Override
    public long count() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("select count(c) from CreditAgreement c", Long.class)
                .getSingleResult();
    }
}
