package com.jia.HepsiSurada.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jia.HepsiSurada.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID>
{

	void getByProducts(UUID fromString);

}
