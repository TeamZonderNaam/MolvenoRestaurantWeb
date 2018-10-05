package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import com.capgemini.molveno.model.Serving;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServingRepository extends CrudRepository<Serving, Integer> {
}
