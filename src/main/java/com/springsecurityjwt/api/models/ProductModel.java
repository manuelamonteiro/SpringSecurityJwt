package com.springsecurityjwt.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.springsecurityjwt.api.dtos.ProductDTO;

@Table(name = "tb_products")
@Entity(name = "tb_products")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	private Integer price;

	public ProductModel(ProductDTO data) {
		this.price = data.getPrice();
		this.name = data.getName();
	}
}