package com.jia.HepsiSurada.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.dto.CategoryDTO;
import com.jia.HepsiSurada.model.Category;
import com.jia.HepsiSurada.model.Product;

@Service
public interface CategoryService
{
	public Result addCategory(CategoryDTO categoryDTO);

	//public DataResult<List<CategoryDTO>> getCategoryList();

	public DataResult<List<Category>> getCategoryList();

	public Result deleteCategorById(String id);

	public DataResult<List<Product>> getProductListByCatID(UUID id);
}
