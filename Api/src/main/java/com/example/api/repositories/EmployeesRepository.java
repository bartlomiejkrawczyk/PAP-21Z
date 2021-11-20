package com.example.api.repositories;

import com.example.api.entities.Employee;
import com.example.api.projections.EmployeeNamesOnly;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeesByEmployeeKindId(Long employeeKindId);

    @Query(value = "SELECT ID, FIRST_NAME, FAMILY_NAME FROM EMPLOYEES WHERE EMPLOYEE_KIND_ID = :employeeKindId ", nativeQuery = true)
    List<EmployeeNamesOnly> findNamesUsingEmployeeKind(Long employeeKindId);
}


