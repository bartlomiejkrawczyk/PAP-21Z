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

    @GetMapping("all")
    public List<Receipt> findAll() {
        return (List<Receipt>) repository.findAll();
    }

    @GetMapping("/employee/{employee}")
    public List<ReceiptInfo> findReceiptsByEmployee(@PathVariable Long employee) {
        return repository.findReceiptsByEmployeeIdAndPaymentEquals(employee, 0);
    }

    @PostMapping
    public Receipt saveReceipt(@RequestBody Receipt receipt) {
        return repository.save(receipt);
    }

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

    @DeleteMapping("/{id}")
    public void deleteReceipt(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
