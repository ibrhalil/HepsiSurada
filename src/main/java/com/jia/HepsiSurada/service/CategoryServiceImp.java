package com.jia.HepsiSurada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.core.SuccessDataResult;
import com.jia.HepsiSurada.core.SuccessResult;
import com.jia.HepsiSurada.dto.CategoryDTO;
import com.jia.HepsiSurada.model.Category;
import com.jia.HepsiSurada.model.Product;
import com.jia.HepsiSurada.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService 
{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Result addCategory(CategoryDTO categoryDTO) 
	{
		categoryRepository.save(new Category(UUID.randomUUID(),categoryDTO.getName(),null));
		return new SuccessResult("Categori Eklendi");
	}

	@Override
	public DataResult<List<CategoryDTO>> getCategoryList() 
	{
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDTO> categDTO = new ArrayList<>();
		for (Category categ : categories) {
			categDTO.add(new CategoryDTO(categ.getName()));
		}
		return new SuccessDataResult<List<CategoryDTO>>(categDTO,"Category Listelendi");
	}

	@Override
	public Result deleteCategorById(String id) 
	{
		categoryRepository.deleteById(UUID.fromString(id));
		return new SuccessResult("Category Silindi");
	}

	@Override
	public DataResult<List<Product>> getProductListByCatID(UUID id) 
	{
		
		categoryRepository.getByProducts(id);
		return null;
	}
	
	
}