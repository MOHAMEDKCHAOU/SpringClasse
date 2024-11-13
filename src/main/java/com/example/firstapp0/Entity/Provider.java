package com.example.firstapp0.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates no-args constructor
@EqualsAndHashCode(callSuper = true)  // Include superclass fields in equals/hashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Provider extends User {


    String matricule;
    String service;
    String company;
}
