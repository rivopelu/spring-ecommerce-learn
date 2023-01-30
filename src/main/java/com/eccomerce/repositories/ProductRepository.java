package com.eccomerce.repositories;

import com.eccomerce.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, String> {
}
