package com.test.bank.credit_application_module.service;

import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
import java.util.List;

public interface CreditApplicationService {
    CreditApplicationDTO create (CreditApplicationDTO creditApplication);
    CreditApplicationDTO findById (Long id);
    List<CreditApplicationDTO> findAll ();
    List<CreditApplicationDTO> findAllPaginated (int page, int size);
    Long count();
}
