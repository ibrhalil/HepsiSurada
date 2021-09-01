package com.jia.HepsiSurada.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket 
{
	@Id
	@Column(name = "basket_id")
	private UUID id;
	
	@Column(name = "basket_total_amount")
	private double totalAmount;
	
	@Transient
	private List<Product> products;
}
