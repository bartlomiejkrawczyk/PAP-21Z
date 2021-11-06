package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;

@Table(name = "RECEIPTS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PAYMENT")
    private Long payment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TABLE_ID", nullable = false)
    private com.example.api.entities.Table table;

}
