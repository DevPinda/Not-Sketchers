package com.cs2tp.notsketchers.entities;

import com.cs2tp.notsketchers.config.CustomerPasswordEncoder;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private int customerId;

    @Column(name = "Customer_Forename")
    private String customerForename;

    @Column(name = "Customer_Lastname")
    private String customerLastname;

    @Column(name = "Customer_PhoneNumber")
    private String customerPhoneNumber;

    @Column(name = "Customer_Email")
    private String customerEmail;

    @Column(name = "Customer_Password")
    private String customerPassword;

    @Column(name = "Customer_AddressLine1")
    private String customerAddressLine1;

    @Column(name = "Customer_AddressLine2")
    private String customerAddressLine2;

    @Column(name = "Customer_Postcode")
    private String customerPostcode;

    @Column(name = "Customer_IsAdmin")
    private int customerIsAdmin;

    public int getCustomerId(){
        return customerId;
    }

    public String getCustomerForeName(){
        return customerForename;
    }

    public String getCustomerLastName(){
        return customerLastname;
    }

    public String getCustomerPhoneNumber(){
        return customerPhoneNumber;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public String getCustomerPassword(){
        return customerPassword;
    }

    public String getCustomerAddressLine1(){
        return customerAddressLine1;
    }

    public String getCustomerAddressLine2(){
        return customerAddressLine2;
    }

    public String getCustomer_Postcode(){
        return customerPostcode;
    }

    public int getCustomerIsAdmin(){
        return customerIsAdmin;
    }

    public void setCustomerForeName(String customerForename){
        this.customerForename = customerForename;
    }

    public void setCustomerLastName(String customerLastname){
        this.customerLastname = customerLastname;
    }

    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }

    public void setCustomerPassword(String customerPassword){
        CustomerPasswordEncoder customerPasswordEncoder = new CustomerPasswordEncoder(12);
        this.customerPassword = customerPasswordEncoder.encode(customerPassword);
    }

    public void setCustomerContactNumber(String customerPhoneNumber){
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setCustomerAddressLine1(String addressLine1){
        this.customerAddressLine1 = addressLine1;
    }

    public void setCustomerAddressLine2(String addressLine2){
        this.customerAddressLine2 = addressLine2;
    }

    public void setCustomerPostcode(String postcode){
        this.customerPostcode = postcode;
    }

    public boolean isCustomerIsAdmin() {
        boolean isAdmin = false;
        if (customerIsAdmin == 1) {
            isAdmin = true;
        } else if (customerIsAdmin == 0) {
            isAdmin = false;
        } else {
            isAdmin = false;
        }
        return isAdmin;
    }
}
