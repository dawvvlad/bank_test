package com.test.bank.client_module.entity;

import com.test.bank.client_module.dto.ClientDTO;
import com.test.bank.client_module.enums.MaritalStatus;
import com.test.bank.credit_application_module.entity.CreditApplication;
import jakarta.persistence.*;
import lombok.Data;

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
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private CreditApplication creditApplication;

    @Column(name = "work_experience")
    private Integer workExperience;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "organization")
    private String organization;

    public Client(){};


    // конвертация DTO в Entity
    public Client(ClientDTO clientDTO) {
        this.firstName = clientDTO.getFirstName();
        this.middleName = clientDTO.getMiddleName();
        this.lastName = clientDTO.getLastName();
        this.passportDetails = clientDTO.getPassportDetails();
        this.phoneNumber = clientDTO.getPhoneNumber();
        this.address = clientDTO.getAddress();
        this.maritalStatus = clientDTO.getMaritalStatus();
        this.workExperience = clientDTO.getWorkExperience();
        this.jobTitle = clientDTO.getJobTitle();
        this.organization = clientDTO.getOrganization();
    }
}
