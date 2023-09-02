package com.example.login.controller;

import com.example.login.model.Customer;
import com.example.login.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@AllArgsConstructor
@CrossOrigin(origins = "http://192.168.56.1:3000")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam(name = "email") String email,
                                @RequestParam(name = "password") String password) {
        return customerService.getCustomer(email,password);
    }

    @PostMapping("/add")
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping("/delete")
    public void deleteCustomerByEmail(@RequestParam(name = "email") String email) {
        customerService.deleteCustomerByEmail(email);
    }
}
