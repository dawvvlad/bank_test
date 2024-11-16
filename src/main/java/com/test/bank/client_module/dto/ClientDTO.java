package com.test.bank.client_module.dto;

import com.test.bank.client_module.entity.Client;
import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public ClientDTO() {}

    public ClientDTO(Long id, String firstName, String middleName, String lastName, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.middleName = client.getMiddleName();
        this.lastName = client.getLastName();
        this.phoneNumber = client.getPhoneNumber();
        this.address = client.getAddress();
    }
}
