package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {
}
