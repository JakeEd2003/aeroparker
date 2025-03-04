package com.aeroparker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import com.aeroparker.repository.CustomerRepo;
import com.aeroparker.model.Customer;


import java.util.Optional;

@Controller
public class RegistrationCont {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/registration")
    public String showRegForm(Model model){
        model.addAttribute("customer", new Customer());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerCustomer(@Valid @ModelAttribute Customer customer, BindingResult result, Model model){
        //check if email already exists as this has to be unique
        Optional<Customer> existingCust = customerRepo.findByEmailAddressIgnoreCase(customer.getEmailAddress());
        if (existingCust.isPresent()){
            result.rejectValue("emailAddress", "error.customer", "Email has already been registered!");;
        }
        //if not valid, display the form again
        if (result.hasErrors()){
            return "registration";
        }

        //if valid, save the customer and load the success page
        System.out.println(customer); // Check if the addressLine1 is set
        customerRepo.save(customer);
        return "success";
    }   

}
