package com.jia.HepsiSurada.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.core.SuccessDataResult;
import com.jia.HepsiSurada.core.SuccessResult;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Category;
import com.jia.HepsiSurada.model.Product;
import com.jia.HepsiSurada.repository.CategoryRepository;
import com.jia.HepsiSurada.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public DataResult<Product> getProductById(UUID id) {
		
		return new SuccessDataResult<Product>(productRepository.findById(id).get());
	}

	@Override
	public DataResult<Product> getProductByBrand(String brand) {
		
		return new SuccessDataResult<Product>(productRepository.findByBrand(brand));
	}

	@Override

	public Boolean getStock(UUID id) {
		Product product = productRepository.getById(id);
		return product.isStock();
	}


	@Override
	public Result updateProuctById(UUID id,ProductDTO productDTO) {
		Product product = productRepository.getById(id);
		product.setBrand(productDTO.getBrand());
		product.setPrice(productDTO.getPrice());
		product.setName(productDTO.getName());
		product.setDetails(productDTO.getDetails());
		productRepository.save(product);
		return new SuccessResult("Ürün bilgisi güncellendi.");
	}

	@Override
	public Result deleteProductById(UUID id) {
		productRepository.deleteById(id);
		return new SuccessResult("Ürün silindi.");
	}

	@Override
	public Result deleteProductByBrand(String brand) {
		Product product = productRepository.findByBrand(brand);
		productRepository.delete(product);
		return new SuccessResult("Marka ürünleri silindi.");
	}

	@Override
	public DataResult<List<Product>> findAll() {
		
		return new SuccessDataResult<List<Product>>(productRepository.findAll(),"Ürünler listelendi.");
	}

	@Override
	public Result addProduct(ProductDTO productDTO) {
		Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString(productDTO.getCategoryId()));
		
        if (!optionalCategory.isPresent()) 
        {
            throw new RuntimeErrorException(null, "Category not exist");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setId(UUID.randomUUID());
        product.setCategory(optionalCategory.get());
        product.setStock(true);
        productRepository.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<List<Product>> sortedList(String type, String value) {
		Sort sort = null;
		
		switch (value) 
		{
		case "price":
			if(type.equalsIgnoreCase("ASC"))
			{
				sort = Sort.by(Sort.Direction.ASC,"price");
			}
			else if(type.equalsIgnoreCase("DESC"))
			{
				sort = Sort.by(Sort.Direction.DESC,"price");
			}
			break;
			
		case "brand":
			if(type.equalsIgnoreCase("ASC"))
			{
				sort = Sort.by(Sort.Direction.ASC,"brand");
			}
			else if(type.equalsIgnoreCase("DESC"))
			{
				sort = Sort.by(Sort.Direction.DESC,"brand");
			}
			break;

		default:
			sort = Sort.by(Sort.Direction.ASC,"brand");
			break;
		}
		
		return new SuccessDataResult<List<Product>>(productRepository.findAll(sort));
	}
	
}
