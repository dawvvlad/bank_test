package com.test.bank.credit_agreement_module.service;

import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
import com.test.bank.credit_agreement_module.entity.CreditAgreement;
import com.test.bank.credit_agreement_module.repo.CreditAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CreditAgreement savedAgreement = creditAgreementRepository.save(creditAgreement);
        CreditAgreementDTO result = new CreditAgreementDTO(savedAgreement);

        System.out.println(result);

        return result;
    }

    @Override
    public List<CreditAgreementDTO> findAllPaginated(int page, int size) {

        List<CreditAgreement> creditAgreements = creditAgreementRepository.findAllPaginated(page, size);
        List<CreditAgreementDTO> creditAgreementDTOS = new ArrayList<>();

        if (creditAgreements == null) {
            return Collections.emptyList();
        }
        for (CreditAgreement creditAgreement : creditAgreements) {
            creditAgreementDTOS.add(new CreditAgreementDTO(creditAgreement));
        }
        return creditAgreementDTOS;
    }

    @Override
    public long count() {
        return creditAgreementRepository.count();
    }
}
