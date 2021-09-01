package com.jia.HepsiSurada.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Product;

@Service
public interface ProductService {
	
	DataResult<List<Product>> findAll();
	
	DataResult<Product> getProductByBrand (String brand);
	
	DataResult<List<Product>> sortedList(String type, String value);
	
	Result updateProuctById(UUID id,ProductDTO productDTO);
	
	Result deleteProductById(UUID id);
	
	Result deleteProductByBrand(String brand);

	Boolean getStock(UUID id);
	
	Result addProduct(ProductDTO productDTO);

	DataResult<Product> getProductById(UUID id);
}
