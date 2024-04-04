package com.springsecurityjwt.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springsecurityjwt.api.dtos.ProductDTO;
import com.springsecurityjwt.api.models.ProductModel;
import com.springsecurityjwt.api.repositories.ProductRepository;

@Service
public class ProductService {
	final ProductRepository productRepository;

	ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<ProductModel> findAll() {
		return productRepository.findAll();
	}

	public ProductModel save(ProductDTO dto) {
		ProductModel user = new ProductModel(dto);
		return productRepository.save(user);
	}

}
