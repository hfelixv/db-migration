package com.bookstore.repository;



import com.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Customer, Long> {
}