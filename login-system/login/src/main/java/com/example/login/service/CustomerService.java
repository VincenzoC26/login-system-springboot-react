package com.example.login.service;


import com.example.login.model.Customer;
import com.example.login.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(String email, String password) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
        if (customerOptional.isPresent()) {
            if (!customerOptional.get().getPassword().equals(password)) {
                throw new IllegalStateException("password is not correct for email: "+ email);
            }
        }else {
            throw new IllegalStateException("email: " + email + " is not present");
        }
        return customerOptional.get();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository
                .findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomerByEmail(String email) {
        Optional<Customer> customerOptional = customerRepository
                .findCustomerByEmail(email);
        if(customerOptional.isEmpty()) {
            throw new IllegalStateException("customer with email: " + email + " doesn't exist");
        }
        customerRepository.deleteById(customerOptional.get().getId());
    }

}
