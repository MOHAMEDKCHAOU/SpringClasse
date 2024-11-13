package com.example.firstapp0.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@FieldDefaults (level = AccessLevel.PUBLIC)
public class Order0 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Ref;
    long Price;
    String date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> products;

}
