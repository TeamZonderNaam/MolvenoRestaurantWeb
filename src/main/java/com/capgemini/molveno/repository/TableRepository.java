package com.capgemini.molveno.repository;

import com.capgemini.molveno.model.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends CrudRepository<Table, Long> {
}
