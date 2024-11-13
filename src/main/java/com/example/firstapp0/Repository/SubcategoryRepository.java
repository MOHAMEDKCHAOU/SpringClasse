package com.example.firstapp0.Repository;

import com.example.firstapp0.Entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Integer> {
}
