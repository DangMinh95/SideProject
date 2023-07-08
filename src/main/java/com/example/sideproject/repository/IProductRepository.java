package com.example.sideproject.repository;

import com.example.sideproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
