package com.example.api.repositories;

import com.example.api.entities.SpecialRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see SpecialRequest
 */
@Repository
public interface SpecialRequestsRepository extends CrudRepository<SpecialRequest, Long> {
}
