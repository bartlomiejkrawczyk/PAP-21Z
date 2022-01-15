package com.example.api.repositories;

import com.example.api.entities.Order;
import com.example.api.projections.OrderInfoCook;
import com.example.api.projections.OrderInfoWaiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see Order
 */
@Repository
public interface OrdersRepository extends CrudRepository<Order, Long> {

    /**
     * Method that retrieves from the database only values needed by the projection
     *
     * @param receiptId id of the receipt
     * @return List of information on order assigned to the receiptId
     * @see OrderInfoWaiter
     */
    List<OrderInfoWaiter> findOrdersByReceiptId(Long receiptId);

    /**
     * Method that retrieves from the database only values needed by the projection
     *
     * @param status Status of orders needed to be retrieved
     * @return List of information on order with given status and without assigned employee
     * @see OrderInfoCook
     */
    List<OrderInfoCook> findByStatusAndEmployeeIsNull(int status);

    /**
     * Method that retrieves from the database only values needed by the projection
     *
     * @param status Status of orders needed to be retrieved
     * @return List of information on order with given status and with assigned employee
     * @see OrderInfoCook
     */
    List<OrderInfoCook> findByStatusAndEmployeeIsNotNull(int status);
}
