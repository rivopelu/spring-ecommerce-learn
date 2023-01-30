package com.eccomerce.services;

import com.eccomerce.entities.Products;
import com.eccomerce.exception.ResourceNotFoundException;
import com.eccomerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> FindAll() {
        return productRepository.findAll();
    }

    public Products findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product tidak di temukan"));
    }

    public Products create(Products product) {
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    public Products edit(Products product) {
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
