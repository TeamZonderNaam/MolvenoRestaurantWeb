package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> { }
