package com.example.api.projections;


/**
 * Special interface used by Spring Boot to retrieve only needed information
 *
 * @see com.example.api.entities.Product
 */
public interface ProductInfoCook {
    Long getId();

    String getName();

    String getUnit();
}
