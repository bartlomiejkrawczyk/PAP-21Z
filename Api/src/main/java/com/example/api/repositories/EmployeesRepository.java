package com.example.api.repositories;

import com.example.api.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeesByEmployeeKindId(Long employeeKindId);
}
