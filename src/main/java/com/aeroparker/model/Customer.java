package com.aeroparker.model;

import java.security.Timestamp;
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
    private int id;

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
    private String firstName, lastName;

    @NotBlank
    @Column(nullable = false, length = 255)
    @Size(max = 255)
    private String addressLine1;

    @Column(nullable = true, length = 255)
    @Size(max = 255)
    private String addressLine2;

    @Column(nullable = true, length = 255)
    @Size(max = 255)
    private String city; //city is an optional input

    @NotBlank
    @Size(max = 10)
    private String postcode;

    @Size(max = 20)
    private String phoneNumber;


    //declare getters
    public int getId() {
        return id;
    }
    public LocalDateTime getRegistered(){
        return registered;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getTitle() {
        return title;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    public String getCity() {
        return city;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }



    //declare setters
    public void setId(int id) {
        this.id = id;
    }
    public void setRegistered(LocalDateTime registered){
        this.registered = registered;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName =lastName;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
