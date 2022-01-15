package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Order is an entity that connects two other entities:
 * - Receipt
 * - Dish
 * <p>
 * It holds information about what dish was ordered with which receipt
 * <p>
 * Cooks can get assigned to orders
 * Order can have multiple specialRequests
 * <p>
 * Every order can be in four states (indicated by status and employee):
 * status: 1, employee: null - order requested, but preparing hasn't started
 * status: 1, employee: assigned - order is being prepared
 * status: 2, employee: assigned - order is ready to be served
 * status: 3, employee: assigned - order is served
 *
 * @see Receipt
 * @see Dish
 * @see Employee
 * @see SpecialRequest
 */
@Table(name = "ORDERS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    @GenericGenerator(
            name = "ID_SEQUENCE",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ID_SEQUENCE"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(name = "\"date\"", nullable = false)
    private Long date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DISH_ID", nullable = false)
    private Dish dish;

    @Column(name = "RECEIPT_ID", nullable = false)
    private Long receiptId;

    @OneToMany(mappedBy = "orderId")
    private List<SpecialRequest> requests;

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

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

        Order order = (Order) o;

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(date, order.date)) return false;
        if (!Objects.equals(dish, order.dish)) return false;
        if (!Objects.equals(receiptId, order.receiptId)) return false;
        if (!Objects.equals(status, order.status)) return false;
        return Objects.equals(employee, order.employee);
    }
}