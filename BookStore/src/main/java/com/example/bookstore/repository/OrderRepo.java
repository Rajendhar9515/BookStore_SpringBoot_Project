package com.example.bookstore.repository;

import com.example.bookstore.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, Integer> {
}
