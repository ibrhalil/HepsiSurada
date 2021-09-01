package com.jia.HepsiSurada.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.CustomerLoginDTO;
import com.jia.HepsiSurada.dto.ProductDTO;
import com.jia.HepsiSurada.model.Customer;
import com.jia.HepsiSurada.model.Product;
import com.jia.HepsiSurada.service.CustomerService;

@RestController
@RequestMapping("/api/user")
public class MainController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/login")
	public void checkUser(CustomerLoginDTO customerLoginDTO)
	{
		customerService.checkUser(customerLoginDTO);
	}

}
