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
@Table(name = "SPECIAL_REQUESTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialRequest {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "REQUEST", nullable = false)
    private String request;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "ORDER_ID", nullable = false)
//    private Order order;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;
}
