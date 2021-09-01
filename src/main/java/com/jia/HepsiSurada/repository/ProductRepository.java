package com.jia.HepsiSurada.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jia.HepsiSurada.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	Optional<Product> findById(UUID id);
	
	Product findByBrand (String brand);
	
//	Boolean getStock(UUID id);//bakılıcak
	
	//List<Product> findByOrderByPriceAsc();
	
	//Product updateById(UUID id);
	
//	Product deletetById(UUID id);
	
	void deleteByBrand(String brand);
	
}
