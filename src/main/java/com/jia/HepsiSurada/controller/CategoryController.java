package com.jia.HepsiSurada.controller;

import java.util.List;
import java.util.UUID;

import com.jia.HepsiSurada.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.dto.CategoryDTO;
import com.jia.HepsiSurada.model.Product;
import com.jia.HepsiSurada.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController 
{
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public Result addCategory(@RequestBody CategoryDTO categoryDTO)
	{
		return categoryService.addCategory(categoryDTO);
	}
	
	@GetMapping("/all")
	public DataResult<List<Category>> getCategoryList()
	{
		return categoryService.getCategoryList();
	}
	
	@DeleteMapping("/{category-id}/delete")
	public Result deleteCategorById(@PathVariable("category-id") String id)
	{
		return categoryService.deleteCategorById(id);
	}
	
	@GetMapping("/{category-id}")
	public DataResult<List<Product>> listProductByCategoryId(@PathVariable("category-id") UUID id)
	{
		return categoryService.getProductListByCatID(id);
	}
}