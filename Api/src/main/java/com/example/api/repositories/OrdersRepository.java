package com.example.api.repositories;

import com.example.api.entities.Order;
import com.example.api.projections.OrderInfoCook;
import com.example.api.projections.OrderInfoWaiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Order, Long> {

    List<OrderInfoWaiter> findOrdersByReceiptId(Long receiptId);

    List<OrderInfoCook> findByStatusAndEmployeeIsNull(int status);

    List<OrderInfoCook> findByStatusAndEmployeeIsNotNull(int status);
}
