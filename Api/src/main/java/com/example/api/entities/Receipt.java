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
 * Entity that stores information about receipt
 * <p>
 * Receipt can be in two states (indicated by payment):
 * - payment == 0 - the receipt is open - waiter can add more orders to the receipt
 * - payment != 0 - the receipt is closed - every order included in order must have status 3 - already served
 * <p>
 * Waiter can be assigned to receipt
 * - employee will add orders for dishes
 * and will handle every prepared order in this receipt
 * <p>
 * Every receipt is assigned to one table
 *
 * @see Order
 * @see Employee
 * @see com.example.api.entities.Table
 */
@Table(name = "RECEIPTS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
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

    @Column(name = "PAYMENT")
    private Integer payment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "TABLE_ID")
    private com.example.api.entities.Table table;

    @OneToMany(mappedBy = "receiptId")
    private List<Order> orders;

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

        Receipt receipt = (Receipt) o;

        if (!Objects.equals(id, receipt.id)) return false;
        if (!Objects.equals(payment, receipt.payment)) return false;
        if (!Objects.equals(employee, receipt.employee)) return false;
        return Objects.equals(table, receipt.table);
    }

}
