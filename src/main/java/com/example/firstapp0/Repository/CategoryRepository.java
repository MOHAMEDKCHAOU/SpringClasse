package com.example.firstapp0.Repository;

import com.example.firstapp0.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
