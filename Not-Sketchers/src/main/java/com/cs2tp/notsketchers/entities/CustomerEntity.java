package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
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

    public boolean isCustomerIsAdmin() {
        Boolean isAdmin = false;
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
