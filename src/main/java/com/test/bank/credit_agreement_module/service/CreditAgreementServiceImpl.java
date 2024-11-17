package com.test.bank.credit_agreement_module.service;

import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.repo.CreditAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CreditAgreementServiceImpl implements CreditAgreementService{

    private final CreditAgreementRepository creditAgreementRepository;

    @Autowired
    public CreditAgreementServiceImpl(CreditAgreementRepository creditAgreementRepository) {
        this.creditAgreementRepository = creditAgreementRepository;
    }

    @Override
    public CreditAgreementDTO findById(Long id) {
        CreditAgreement creditAgreement = creditAgreementRepository.find(id);
        return new CreditAgreementDTO(creditAgreement);
    }

    @Override
    public CreditAgreementDTO create(CreditAgreementDTO creditAgreementDTO) {
        CreditAgreement creditAgreement = new CreditAgreement(creditAgreementDTO);
        creditAgreementRepository.save(creditAgreement);
        return creditAgreementDTO;
    }

    @Override
    public List<CreditAgreementDTO> findAll() {

        List<CreditAgreement> creditAgreements = creditAgreementRepository.findAll();
        List<CreditAgreementDTO> creditAgreementDTOS = new ArrayList<>();

        if (creditAgreements == null) {
            return Collections.emptyList();
        }
        for (CreditAgreement creditAgreement : creditAgreements) {
            creditAgreementDTOS.add(new CreditAgreementDTO(creditAgreement));
        }
        return creditAgreementDTOS;
    }
}
