package com.example.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SPECIAL_REQUESTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialRequest {

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

    @Column(name = "REQUEST", nullable = false)
    private String request;

    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialRequest that = (SpecialRequest) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(request, that.request)) return false;
        return Objects.equals(orderId, that.orderId);
    }

}
