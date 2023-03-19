package com.cs2tp.notsketchers.repository;

import com.cs2tp.notsketchers.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findByCustomerEmail(String customerEmail);
}
