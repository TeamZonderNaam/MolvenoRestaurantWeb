package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Guest;
import com.capgemini.molveno.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    private GuestRepository repository;

    public int create(Guest guest) {
        Guest created = repository.save(guest);
        return created.getId();
    }

    public Iterable<Guest> all() {
        return repository.findAll();
    }

    public Guest read(final int id) {
        Optional<Guest> guest = repository.findById(id);
        if (guest.isPresent()) {
            return guest.get();
        }
        return null;
    }

    public Guest update(Guest guest) {
        return repository.save(guest);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
