package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Customer;
import com.capgemini.molveno.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public int create(Customer customer) {
        Customer created = repository.save(customer);
        return created.getId();
    }

    public Iterable<Customer> all() {
        return repository.findAll();
    }

    public Customer read(final int id) {
        Optional<Customer> person = repository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        return null;
    }

    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
