package com.jia.HepsiSurada.controller;

import java.util.List;
import java.util.UUID;

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
import com.jia.HepsiSurada.core.SuccessDataResult;
import com.jia.HepsiSurada.core.SuccessResult;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Customer;
import com.jia.HepsiSurada.model.Product;
import com.jia.HepsiSurada.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public DataResult<List<Product>> getProductList()
	{
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<Product> getProductById(@PathVariable("id") UUID id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping("/brand/{brand}")
	public DataResult<Product> getProductByBrand(@PathVariable("brand") String brand)
	{
		return productService.getProductByBrand(brand);
	}
	
	@GetMapping("/order")
	public Result sortedList(String type, String value)
	{
		return productService.sortedList(type,value);
	}
	
	@PostMapping("/update-product/{id}")
	public Result updateProductById(@PathVariable("id") UUID id, ProductDTO productDTO)
	{
		return productService.updateProuctById(id,productDTO);
	}
	
	@DeleteMapping("/delete-product/{brand}/")
	public Result deleteProductByBrand(@PathVariable("brand") String brand) {
		return productService.deleteProductByBrand(brand);
	}
	
	@DeleteMapping("/delete/{id}/")
	public Result deleteProductById(@PathVariable("id") UUID id) {
		return productService.deleteProductById(id);
	}
	
	@PostMapping("/add")
	public Result addProduct(@RequestBody ProductDTO productDTO) {
		productService.addProduct(productDTO);
		return new SuccessResult();
	}

}
