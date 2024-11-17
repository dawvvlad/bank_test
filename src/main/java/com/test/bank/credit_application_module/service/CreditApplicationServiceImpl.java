package com.test.bank.credit_application_module.service;

import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import com.test.bank.credit_application_module.entity.CreditApplication;
import com.test.bank.credit_application_module.repo.CreditApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService {

    private final CreditApplicationRepository applicationRepository;

    @Autowired
    public CreditApplicationServiceImpl(CreditApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public CreditApplicationDTO create(CreditApplicationDTO creditApplicationDTO) {
        CreditApplication application = new CreditApplication(creditApplicationDTO);
        applicationRepository.save(application);
        return creditApplicationDTO;
    }

    @Override
    public CreditApplicationDTO findById(Long id) {
        CreditApplication creditApplication = applicationRepository.find(id);
        if (creditApplication == null) {
            return null;
        }
        return new CreditApplicationDTO(creditApplication);
    }

    @Override
    public List<CreditApplicationDTO> findAll() {
        List<CreditApplication> creditApplications = applicationRepository.findAll();
        List<CreditApplicationDTO> creditApplicationDTOS = new ArrayList<>();

        if (creditApplications == null) {
            return Collections.emptyList();
        }

        for (CreditApplication creditApplication : creditApplications) {
            creditApplicationDTOS.add(new CreditApplicationDTO(creditApplication));
        }
        return creditApplicationDTOS;
    }
}
