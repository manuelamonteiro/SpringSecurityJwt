package com.springsecurityjwt.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurityjwt.api.dtos.ProductDTO;
import com.springsecurityjwt.api.models.ProductModel;
import com.springsecurityjwt.api.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<Object> getProducts() {
		List<ProductModel> products = productService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody @Valid ProductDTO body) {
		ProductModel product = productService.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

}