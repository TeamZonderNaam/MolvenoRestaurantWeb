package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    // Custom JPA query
    public List<Reservation> findAllByDate(LocalDate date);
}
