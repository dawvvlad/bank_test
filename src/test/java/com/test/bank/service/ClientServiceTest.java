package com.test.bank.service;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.entity.Client;
import com.test.bank.client_module.enums.MaritalStatus;
import com.test.bank.client_module.repo.ClientRepositoryImpl;
import com.test.bank.client_module.service.ClientServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Query<Client> query;

    @Mock
    private ClientRepositoryImpl clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearch() {
        List<Client> mockClients = new ArrayList<>();

        ClientDTO mockClientDTO = new ClientDTO(1L,
                "Вася",
                "Васильев",
                "Васильевич",
                "123",
                "22903",
                "Петрова улица",
                MaritalStatus.married,
                4,
                "Сотрудник",
                "Рога и копыта",
                1L
                );
        ClientDTO mockClientDTO2 = new ClientDTO(2L,
                "Петя",
                "Петров",
                "Петрович",
                "342",
                "12345",
                "Петрова улица",
                MaritalStatus.single,
                5,
                "Сотрудник",
                "Рога и копыта",
                2L
        );

        mockClients.add(new Client(mockClientDTO));
        mockClients.add(new Client(mockClientDTO2));

        when(clientRepository.search(anyString())).thenReturn(mockClients);
        List<ClientDTO> result = clientService.search("Doe");

        assertEquals(2, result.size());
        assertEquals("Вася", result.get(0).getFirstName());
        assertEquals("Петя", result.get(1).getFirstName());

        verify(clientRepository).search("Doe");
    }

}
