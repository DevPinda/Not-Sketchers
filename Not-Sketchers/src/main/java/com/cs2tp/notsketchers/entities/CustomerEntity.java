package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    public int Customer_ID;

    @Column(name = "Customer_Forename")
    public String Customer_Forename;

    @Column(name = "Customer_Lastname")
    public String Customer_Lastname;

    @Column(name = "Customer_PhoneNumber")
    public String Customer_PhoneNumber;

    @Column(name = "Customer_Email")
    public String Customer_Email;

    @Column(name = "Customer_Password")
    public String Customer_Password;

    @Column(name = "Customer_AddressLine1")
    public String Customer_AddressLine1;

    @Column(name = "Customer_AddressLine2")
    public String Customer_AddressLine2;

    @Column(name = "Customer_Postcode")
    public String Customer_Postcode;

    @Column(name = "Customer_IsAdmin")
    public int Customer_IsAdmin;

    public int getCustomerId(){
        return Customer_ID;
    }

    public String getCustomerForeName(){
        return Customer_Forename;
    }

    public String getCustomerLastName(){
        return Customer_Lastname;
    }

    public String getCustomerPhoneNumber(){
        return Customer_PhoneNumber;
    }

    public String getCustomerEmail(){
        return Customer_Email;
    }

    public String getCustomer_Password(){
        return Customer_Password;
    }

    public String getCustomerAddressLine1(){
        return Customer_AddressLine1;
    }

    public String getCustomerAddressLine2(){
        return Customer_AddressLine2;
    }

    public String getCustomer_Postcode(){
        return Customer_Postcode;
    }

    public int getCustomerIsAdmin(){
        return Customer_IsAdmin;
    }
}
