package com.example.api.repositories;

import com.example.api.entities.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see Table
 */
@Repository
public interface TablesRepository extends CrudRepository<Table, Long> {
}
