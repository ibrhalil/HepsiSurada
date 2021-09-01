package com.jia.HepsiSurada.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders 
{
	@Id
	@Column(name = "orders_id")
	private UUID id;
	
	@Column(name = "orders_total_amount")
	private double totalAmount;
	
	@CollectionTable
	private List<Product> products;
}
