package com.example.api.repositories;

import com.example.api.entities.EmployeeKind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeKindsRepository extends CrudRepository<EmployeeKind, Long> {
}
