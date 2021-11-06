package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISH_EXTRA_INFORMATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishExtraInformation {

    @Id
    @Column(name = "DISH_ID", nullable = false)
    private Long id;

    @Column(name = "RECIPE")
    private byte[] recipe;

}
