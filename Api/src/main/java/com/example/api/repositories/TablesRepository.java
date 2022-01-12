package com.example.api.repositories;

import com.example.api.entities.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends CrudRepository<Table, Long> {
}
