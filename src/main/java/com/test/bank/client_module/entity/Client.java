package com.test.bank.client_module.entity;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.enums.MaritalStatus;
import com.test.bank.credit_application_module.entity.CreditApplication;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_details")
    private String passportDetails;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @OneToMany(mappedBy = "client")
    private List<CreditApplication> creditApplications;

    public Client(){};

    public Client(ClientDTO clientDTO) {
        this.firstName = clientDTO.getFirstName();
        this.middleName = clientDTO.getMiddleName();
        this.lastName = clientDTO.getLastName();
        this.passportDetails = clientDTO.getPassportDetails();
        this.phoneNumber = clientDTO.getPhoneNumber();
        this.address = clientDTO.getAddress();
        this.maritalStatus = clientDTO.getMaritalStatus();
    }

    public void addCreditApplication(CreditApplication creditApplication){
        if(this.creditApplications == null){
            this.creditApplications = new ArrayList<>();
        }
        this.creditApplications.add(creditApplication);
    }
}
