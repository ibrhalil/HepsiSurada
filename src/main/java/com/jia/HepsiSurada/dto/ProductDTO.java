package com.jia.HepsiSurada.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jia.HepsiSurada.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private double price;
	
	private String brand;
	
	private String details;
	
	private String name;

    private String categoryId;
}
