package com.example.api.repositories;

import com.example.api.entities.Receipt;
import com.example.api.projections.ReceiptInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptsRepository extends CrudRepository<Receipt, Long> {

    List<ReceiptInfo> findReceiptsByEmployeeIdAndPaymentEquals(Long employeeId, Integer payment);
}
