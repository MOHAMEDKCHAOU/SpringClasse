package com.example.firstapp0.Repository;

import com.example.firstapp0.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
