package com.example.login.repository;

import com.example.login.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT customer FROM Customer customer WHERE customer.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);


}