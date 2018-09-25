package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Person;
import com.capgemini.molveno.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public int create(Person person) {
        Person created = repository.save(person);
        return created.getId();
    }

    public Iterable<Person> all() {
        return repository.findAll();
    }

    public Person read(final int id) {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }

        return null;
    }

    public Person update(Person person) {
        return repository.save(person);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
