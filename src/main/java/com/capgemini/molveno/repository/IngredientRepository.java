package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Ingredient;
import com.capgemini.molveno.model.Unit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
