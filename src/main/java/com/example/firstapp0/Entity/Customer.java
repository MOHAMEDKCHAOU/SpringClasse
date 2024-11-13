package com.example.firstapp0.Entity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Customer extends User {

    String address;
    String city;
}
