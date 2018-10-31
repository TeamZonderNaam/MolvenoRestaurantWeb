package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Category;
import com.capgemini.molveno.model.Film;
import com.capgemini.molveno.repository.CategoryRepository;
import com.capgemini.molveno.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private FilmRepository repository;

    @Autowired
    public void setRepository(FilmRepository repository) {
        this.repository = repository;
    }

    public int create(Film film) {
        Film created = repository.save(film);

        return created.getId();
    }

    public List<Film> all() {
        Iterable<Film> iterable = repository.findAll();
        List<Film> categories = new ArrayList<>();
        iterable.forEach(categories::add);
        return categories;
    }

    public Film read(final int id) {
        Optional<Film> film = repository.findById(id);
        if (film.isPresent()) {
            return film.get();
        }

        return null;
    }

    public Film update(Film film) {
        Optional<Film> oldItem = repository.findById(film.getId());
        if (oldItem.isPresent()) {
            if (film.getName() != null) {
                oldItem.get().setName(film.getName());
            }
            return repository.save(oldItem.get());
        }

        return null;
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
