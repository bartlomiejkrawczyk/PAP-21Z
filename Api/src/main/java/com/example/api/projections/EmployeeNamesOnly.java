package com.example.api.projections;


import org.springframework.beans.factory.annotation.Value;


/**
 * Special interface used by Spring Boot to retrieve only needed information
 *
 * @see com.example.api.entities.Employee
 */
public interface EmployeeNamesOnly {

    Long getId();

    @SuppressWarnings({"ELValidationInJSP", "SpringElInspection"})
    @Value("#{target.FIRST_NAME + ' ' + target.FAMILY_NAME}")
    String getName();

}
