package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "ORDERS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "\"date\"", nullable = false)
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DISH_ID", nullable = false)
    private Dish dish;

    @ManyToOne(optional = false)
    @JoinColumn(name = "RECEIPT_ID", nullable = false)
    private Receipt receipt;

}
