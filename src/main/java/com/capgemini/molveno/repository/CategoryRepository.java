package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Category;
import com.capgemini.molveno.model.Unit;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
