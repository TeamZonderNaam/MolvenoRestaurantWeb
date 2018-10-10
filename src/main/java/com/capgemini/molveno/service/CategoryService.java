package com.capgemini.molveno.service;

import com.capgemini.molveno.model.Category;
import com.capgemini.molveno.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    @Autowired
    public void setRepository(CategoryRepository repository) {
        this.repository = repository;
    }

    public int create(Category category) {
        Category created = repository.save(category);

        return created.getId();
    }

    public List<Category> all() {
        Iterable<Category> iterable = repository.findAll();
        List<Category> categories = new ArrayList<>();
        iterable.forEach(categories::add);
        return categories;
    }

    public Category read(final int id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }

        return null;
    }

    public Category update(Category category) {
        Optional<Category> oldItem = repository.findById(category.getId());
        if (oldItem.isPresent()) {
            if (category.getName() != null) {
                oldItem.get().setName(category.getName());
            }
            return repository.save(oldItem.get());
        }

        return null;
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
