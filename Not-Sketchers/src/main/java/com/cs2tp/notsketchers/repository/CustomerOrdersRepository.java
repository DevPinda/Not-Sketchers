package com.cs2tp.notsketchers.repository;

import com.cs2tp.notsketchers.entities.CustomerOrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrdersRepository extends JpaRepository<CustomerOrdersEntity, Integer> {
}
