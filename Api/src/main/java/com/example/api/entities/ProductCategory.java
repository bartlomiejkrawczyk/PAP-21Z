package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Entity used to divide products into categories
 *
 * @see Product
 */
@Table(name = "PRODUCT_CATEGORIES")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 63)
    private String name;

    @OneToMany(mappedBy = "productCategoryId")
    private List<Product> products;

    /**
     * Method used for test purposes
     *
     * @param o object to which this object will be compared
     * @return whether the objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategory that = (ProductCategory) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

}