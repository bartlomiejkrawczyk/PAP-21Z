package com.example.api.repositories;

import com.example.api.entities.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptsRepository extends CrudRepository<Receipt, Long> {
}
