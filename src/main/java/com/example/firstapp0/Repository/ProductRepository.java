package com.example.firstapp0.Repository;

import com.example.firstapp0.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
