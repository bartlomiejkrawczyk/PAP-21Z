package com.example.api.repositories;

import com.example.api.entities.Product;
import com.example.api.projections.ProductInfoCook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Special interface used by Spring Boot
 * to generate methods that can exchange data with the database
 *
 * @see Product
 */
@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {

    /**
     * Method that retrieves from the database only values needed by the projection
     *
     * @param id id of the requested product
     * @return Information on product of given id
     * @see ProductInfoCook
     */
    Optional<ProductInfoCook> findProductInfoCookById(Long id);
}
