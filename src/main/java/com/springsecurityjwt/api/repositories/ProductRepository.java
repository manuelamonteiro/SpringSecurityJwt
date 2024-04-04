package com.springsecurityjwt.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurityjwt.api.models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}