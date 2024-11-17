package com.test.bank.client_module.dto;

import com.test.bank.client_module.entity.Client;
import com.test.bank.client_module.enums.MaritalStatus;
import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String passportDetails;
    private String phoneNumber;
    private String address;
    private MaritalStatus maritalStatus;

    public ClientDTO() {}

    public ClientDTO(Long id, String firstName, String middleName, String passportDetails, String lastName, String phoneNumber, String address, MaritalStatus maritalStatus) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passportDetails = passportDetails;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.maritalStatus = maritalStatus;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.middleName = client.getMiddleName();
        this.passportDetails = client.getPassportDetails();
        this.lastName = client.getLastName();
        this.phoneNumber = client.getPhoneNumber();
        this.address = client.getAddress();
        this.maritalStatus = client.getMaritalStatus();
    }
}
