package com.eccomerce.repositories;

import com.eccomerce.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, String> {

}
