package com.aeroparker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aeroparker.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> { //JpaRepository provides CRUD operations
    Optional<Customer> findByEmailAddressIgnoreCase(String emailAddress); //find customer by email which is the primary key    
} 
