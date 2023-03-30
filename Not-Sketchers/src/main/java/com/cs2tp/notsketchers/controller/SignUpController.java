package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.entities.CustomerEntity;
import com.cs2tp.notsketchers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController{
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/signup")
    public String returnSignUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("contactNumber") String contactNumber,
            @RequestParam("addressLine1") String addressLine1,
            @RequestParam("addressLine2") String addressLine2,
            @RequestParam("postcode") String postcode
    ) {

        CustomerEntity existingCustomer = customerRepository.findByCustomerEmail(email);
        if (existingCustomer != null) {
            return "redirect:/signup?error=existing_email";
        }

        CustomerEntity customer = new CustomerEntity();

        if (!validateInputs(firstName, lastName, email, password, contactNumber, addressLine1, addressLine2, postcode, customer)) {
            return "redirect:/signup?error=invalid_input";
        }

        customerRepository.save(customer);

        return "redirect:/home";
    }

    private boolean validateInputs(String firstName, String lastName, String email, String password, String contactNumber, String addressLine1, String addressLine2, String postcode, CustomerEntity customer) {
        if (firstName != null && firstName.matches("^[a-zA-Z]+$")) {
            customer.setCustomerForename(firstName);
        } else {
            return false;
        }

        if (lastName != null && lastName.matches("^[a-zA-Z]+$")) {
            customer.setCustomerLastName(lastName);
        } else {
            return false;
        }

        if (email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            customer.setCustomerEmail(email);
        } else {
            return false;
        }

        if (password != null && password.length() >= 8) {
            customer.setCustomerPassword(password);
        } else {
            return false;
        }

        if (contactNumber != null) {
            customer.setCustomerContactNumber(contactNumber);
        } else {
            return false;
        }

        if (addressLine1 != null) {
            customer.setCustomerAddressLine1(addressLine1);
        } else {
            return false;
        }

        if (addressLine2 != null) {
            customer.setCustomerAddressLine2(addressLine2);
        } else {
            return false;
        }

        if (postcode != null) {
            customer.setCustomerPostcode(postcode);
        } else {
            return false;
        }

        return true;
    }
}
