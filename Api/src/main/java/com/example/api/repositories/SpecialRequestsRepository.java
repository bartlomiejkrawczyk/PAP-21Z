package com.example.api.repositories;

import com.example.api.entities.SpecialRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialRequestsRepository extends CrudRepository<SpecialRequest, Long> {
}
