package com.example.api.projections;


import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNamesOnly {

    Long getId();

    @Value("#{target.FIRST_NAME + ' ' + target.FAMILY_NAME}")
    String getName();

}
