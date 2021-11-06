package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRODUCTS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 63)
    private String name;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Column(name = "MIN_QUANTITY")
    private Long minQuantity;

    @Column(name = "UNIT", nullable = false, length = 10)
    private String unit;

}
