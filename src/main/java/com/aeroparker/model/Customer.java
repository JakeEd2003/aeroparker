package com.aeroparker.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated value auto increments for primary key value
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime registered = LocalDateTime.now(); //stores the time when someone registers and can't be updated once set

    @Email
    @NotBlank
    @Column(name = "email_address", unique = true, nullable = false) //ensures email isn't blank and is unique
    private String emailAddress;

    @NotBlank
    @Column(nullable = false, length = 5)
    @Size(max = 5) //max used as validation
    private String title;

    //first and last name are the same length with the same constraints so can be included together
    @NotBlank
    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private String firstName, secondName;

    @NotBlank
    @Column(nullable = false, length = 255)
    @Size(max = 255)
    private String addressLine1, addressLine2;

    private String city; //city is an optional input

    @NotBlank
    @Size(max = 10)
    private String postcode;

    @Size(max = 20)
    private String phoneNumber;

    public String getEmailAddress() {
        return emailAddress;
    }

}
