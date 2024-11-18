package com.test.bank.credit_application_module.repo;

import com.test.bank.credit_application_module.entity.CreditApplication;

import java.util.List;

public interface CreditApplicationRepository {
    CreditApplication find(Long id);
    List<CreditApplication> findAll();
    void save(CreditApplication creditApplication);
    List<CreditApplication> findAllPaginated(int page, int size);
    Long count();
}
