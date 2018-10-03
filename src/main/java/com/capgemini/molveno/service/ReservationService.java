package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Reservation;
import com.capgemini.molveno.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    public int create(Reservation reservation){
        Reservation created = repository.save(reservation);
        return created.getId();
    }

    public Iterable<Reservation> all() { return repository.findAll(); }

    public Reservation read(final int id) {
        Optional<Reservation> reservation = repository.findById(id);
        if(reservation.isPresent()) {
            return reservation.get();
        }
        return null;
    }

    public Reservation update(int id, Reservation reservation) { return repository.save(reservation); }

    public void delete(final int id) { repository.deleteById(id); }

}
