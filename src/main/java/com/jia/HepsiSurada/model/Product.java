package com.jia.HepsiSurada.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
	@Id
	@Column(name = "product_id")
	private UUID id;
	
	@Column(name = "product_name")
	//@NotNull(message = "Boş Bırakmayınız.")
	@Size(min = 3, max = 50, message = "3 ile 50 karakter arası olmalıdır.")
	private String name;
	
	@Column(name = "product_price")
	private double price;
	
	@Column(name = "product_brand")
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	private String brand;
	
	@Column(name = "product_img_url")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	private String imgUrl;
	
	@Column(name = "product_has_stock")
	//@NotNull
	private boolean stock;
	
	@Column(name = "product_details")
	private String details;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
}
