package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
