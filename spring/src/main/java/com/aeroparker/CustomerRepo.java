package com.aeroparker;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aeroparker.Customer;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> { //JpaRepository provides CRUD operations
    Optional<Customer> findbyEmailAddressIgnoreCase(String email); //find customer by email which is the primary key
    
} 
