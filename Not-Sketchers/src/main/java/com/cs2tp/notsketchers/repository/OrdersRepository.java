package com.cs2tp.notsketchers.repository;

import com.cs2tp.notsketchers.entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
}
