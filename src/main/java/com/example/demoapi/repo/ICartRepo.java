package com.example.demoapi.repo;

import com.example.demoapi.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepo extends JpaRepository<Cart,Long> {
}
