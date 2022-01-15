package com.example.api.repositories;

import com.example.api.entities.Receipt;
import com.example.api.projections.ReceiptInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see Receipt
 */
@Repository
public interface ReceiptsRepository extends CrudRepository<Receipt, Long> {

    /**
     * Method that retrieves from the database only values needed by the projection
     *
     * @param employeeId id of a waiter
     * @param payment    when payment is equal to 0 this method can query open receipts
     * @return List of information on receipts from given employee and where payment is equal to the payment variable
     * @see ReceiptInfo
     */
    List<ReceiptInfo> findReceiptsByEmployeeIdAndPaymentEquals(Long employeeId, Integer payment);
}
