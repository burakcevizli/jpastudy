package com.burakexample.jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_order")
public class Order {

    @EmbeddedId
    private OrderId id;

    @Embedded
    private Address address;

    private String orderInfo;
    private String anotherField;
}
