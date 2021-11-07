package com.example.api.repositories;

import com.example.api.entities.DishExtraInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishExtraInformationRepository extends CrudRepository<DishExtraInformation, Long> {
}
