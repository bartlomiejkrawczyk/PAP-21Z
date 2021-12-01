package com.example.api.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeId implements Serializable {
    private Long step;
    private Long dishId;
}
