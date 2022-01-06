package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

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

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "PRODUCT_CATEGORY_ID", nullable = false)
//    private ProductCategory productCategory;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false)
    private Long productCategoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(quantity, product.quantity)) return false;
        if (!Objects.equals(minQuantity, product.minQuantity)) return false;
        if (!Objects.equals(unit, product.unit)) return false;
        return Objects.equals(productCategoryId, product.productCategoryId);
    }
}
