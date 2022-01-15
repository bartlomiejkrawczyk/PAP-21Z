package com.example.api.entities;

import lombok.*;

import java.io.Serializable;

/**
 * Special Recipe id that is combined of two values
 * - it is needed by CrudRepository interface
 *
 * @see Recipe
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeId implements Serializable {
    private Long step;
    private Long dishId;
}
