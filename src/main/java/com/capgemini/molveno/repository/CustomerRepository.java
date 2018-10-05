package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepository {
    public void add() { }

    public Customer save(Customer customer) {
        return null;
    }

    public Iterable<Customer> findAll() {
        return null;
    }

    public Optional<Customer> findById(final int id) {
        return null;
    }

    public void deleteById(final int id) {

    }
}
