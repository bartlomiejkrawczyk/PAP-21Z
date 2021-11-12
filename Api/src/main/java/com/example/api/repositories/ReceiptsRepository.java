package com.example.api.repositories;

import com.example.api.entities.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptsRepository extends CrudRepository<Receipt, Long> {

    List<Receipt> findReceiptsByEmployeeId(Long employeeId);
}
