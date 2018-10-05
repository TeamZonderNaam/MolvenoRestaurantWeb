package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Customer;
import com.capgemini.molveno.model.Reservation;
import com.capgemini.molveno.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> { }
