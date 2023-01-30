package com.eccomerce.services;

import com.eccomerce.entities.Products;
import com.eccomerce.exception.BadRequestException;
import com.eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.repositories.CategoryRepository;
import com.eccomerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    private void Validation(Products product) {
        if (!StringUtils.hasText(product.getName())) {
            throw new BadRequestException("Product name required");
        }
        if (product.getCategories() == null) {
            throw new BadRequestException("Categories is required");
        }
        if (!StringUtils.hasText(product.getCategories().getId())) {
            throw new BadRequestException("Categories id is required");
        }
        categoryRepository.findById(product.getCategories().getId()).orElseThrow(
                () -> new BadRequestException("categories id not found")
        );
    }


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Products> FindAll() {
        return productRepository.findAll();
    }

    public Products findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product tidak di temukan"));
    }

    public Products create(Products product) {
        Validation(product);
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    public Products edit(String id, Products product) {
        productRepository.findById(id).orElseThrow(
                () -> new BadRequestException("product id not found")
        );
        Validation(product);
        product.setId(id);
        return productRepository.save(product);
    }


    public Products changeImage(String id, String url) {
        Products products = findById(id);
        products.setImage(url);
        return productRepository.save(products);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

}
