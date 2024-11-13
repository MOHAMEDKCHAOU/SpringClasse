package com.example.firstapp0.Entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@FieldDefaults(level = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    long salary;
    long phone;
    int age;
    String email;
    String password;
}
