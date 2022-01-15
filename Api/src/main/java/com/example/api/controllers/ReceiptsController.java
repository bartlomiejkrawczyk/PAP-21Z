package com.example.api.controllers;

import com.example.api.entities.Receipt;
import com.example.api.projections.ReceiptInfo;
import com.example.api.repositories.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/receipts")
@RestController
public class ReceiptsController {
    private final ReceiptsRepository repository;

    @Autowired
    public ReceiptsController(ReceiptsRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all the receipts available in the database
     *
     * @return List of all the receipts
     */
    @GetMapping("all")
    public List<Receipt> findAll() {
        return (List<Receipt>) repository.findAll();
    }

    /**
     * Retrieve all the open receipts (payment == 0) of given employee
     *
     * @param employee id of the employee
     * @return List of information on employee's open receipts
     */
    @GetMapping("/employee/{employee}")
    public List<ReceiptInfo> findReceiptsByEmployee(@PathVariable Long employee) {
        return repository.findReceiptsByEmployeeIdAndPaymentEquals(employee, 0);
    }

    /**
     * Save given receipt to the database
     *
     * @param receipt values of the receipt
     * @return Updated receipt saved in the database (new id has been generated)
     */
    @PostMapping
    public Receipt saveReceipt(@RequestBody Receipt receipt) {
        return repository.save(receipt);
    }

    /**
     * Update values of the receipt
     *
     * @param newReceipt new values of the receipt
     * @param id         id of the receipt to update
     * @return Updated receipt saved to the database
     */
    @PutMapping("/{id}")
    public Receipt updateReceipt(@RequestBody Receipt newReceipt, @PathVariable Long id) {
        return repository.findById(id)
                .map(receipt -> {
                    receipt.setTable(newReceipt.getTable());
                    receipt.setPayment(newReceipt.getPayment());
                    receipt.setEmployee(newReceipt.getEmployee());
                    return repository.save(receipt);
                })
                .orElseGet(() -> {
                    newReceipt.setId(id);
                    return repository.save(newReceipt);
                });
    }

    /**
     * Delete receipt of given id
     *
     * @param id id of the receipt to delete
     */
    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
