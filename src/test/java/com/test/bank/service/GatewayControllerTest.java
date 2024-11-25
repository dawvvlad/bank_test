//package com.test.bank.service;
//
//import com.test.bank.client_module.dto.ClientDTO;
//import com.test.bank.client_module.enums.MaritalStatus;
//import com.test.bank.core.controller.GatewayController;
//import com.test.bank.credit_application_module.dto.CreditApplicationDTO;
//import com.test.bank.credit_agreement_module.dto.CreditAgreementDTO;
//import com.test.bank.client_module.service.ClientService;
//import com.test.bank.credit_agreement_module.service.CreditAgreementService;
//import com.test.bank.credit_application_module.enums.ApplicationStatus;
//import com.test.bank.credit_application_module.service.CreditApplicationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.ui.Model;
//
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class GatewayControllerTest {
//
//    @Mock
//    private ClientService clientService;
//
//    @Mock
//    private CreditApplicationService creditApplicationService;
//
//    @Mock
//    private CreditAgreementService creditAgreementService;
//
//    @Mock
//    private Model model;
//
//    @InjectMocks
//    private GatewayController gatewayController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testCreateUserAndApplication_Approved() {
//        ClientDTO clientDTO = new ClientDTO(1L, "Вася", "Васильев", "Васильевич", "123", "22903", "Петрова улица",
//                MaritalStatus.married, 4, "Сотрудник", "Рога и копыта", 1L);
//
//        CreditApplicationDTO creditApplicationDTO = new CreditApplicationDTO(1L,
//                false, clientDTO,
//                10000d,
//                0d,
//                12,
//                LocalDateTime.now(),
//                ApplicationStatus.not_approved,  1L);
//
//        when(creditAgreementService.create(any(CreditAgreementDTO.class))).thenReturn(new CreditAgreementDTO());
//
//        String viewName = gatewayController.createUserAndApplication(clientDTO, creditApplicationDTO, model);
//
//        assertEquals("redirect:/agreements/1", viewName); // Переход на страницу соглашения
//        verify(creditAgreementService).create(any(CreditAgreementDTO.class));
//        verify(creditApplicationService).create(creditApplicationDTO); // Если кредит не одобрен
//    }
//
//    @Test
//    public void testCreateUserAndApplication_NotApproved() {
//        ClientDTO clientDTO = new ClientDTO(1L, "Вася", "Васильев", "Васильевич", "123", "22903", "Петрова улица",
//                MaritalStatus.married, 4, "Сотрудник", "Рога и копыта", 1L);
//
//        CreditApplicationDTO creditApplicationDTO = new CreditApplicationDTO(1L,
//                false, clientDTO,
//                10000d,
//                0d,
//                12,
//                LocalDateTime.now(),
//                ApplicationStatus.not_approved,  1L);
//        when(creditAgreementService.create(any(CreditAgreementDTO.class))).thenReturn(new CreditAgreementDTO());
//
//        String viewName = gatewayController.createUserAndApplication(clientDTO, creditApplicationDTO, model);
//
//        assertEquals("redirect:/clients", viewName); // Переход на страницу клиентов
//        verify(creditAgreementService, never()).create(any(CreditAgreementDTO.class)); // не создаем соглашение
//        verify(creditApplicationService).create(creditApplicationDTO); // создание кредитной заявки
//    }
//}
