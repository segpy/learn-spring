package com.jpatutorial.jpaentity.dependency_injection;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository = new CustomerRepository();

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public List<String> getCustomerNames() {
        return customerRepository.getCustomerNames();
    }
}
