package com.jia.HepsiSurada.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category 
{
	@Id
	@Column(name = "category_id")
	private UUID id;
	
	@Column(name = "category_name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Product> products;
}
