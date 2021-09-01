package com.jia.HepsiSurada.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.model.Adress;
import com.jia.HepsiSurada.model.Customer;
import com.jia.HepsiSurada.service.CustomerService;

@Component
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public DataResult<List<Customer>> getListCustomer()
	{
		return customerService.getListCustomer();
	}
	
	@GetMapping("/{nickname}")
	public DataResult<Customer> getCustomerByNickName(@PathVariable("nickname") String nickName)
	{
		return customerService.getCustomerByNickName(nickName);
	}
	
//	@PostMapping("/add")
//	public Result addCustomer(@RequestBody CustomerDTO customerDTO)
//	{
//		return customerService.addCustomer(customerDTO);
//	}
	
	@PostMapping("/update/{nickname}")
	public Result updateCustomerByNickName(@PathVariable("nickname") String nickName,@RequestBody CustomerDTO customerDTO)
	{
		return customerService.updateCustomerByNickName(nickName, customerDTO);
	}
	
	@PostMapping("/updatePW/{nickname}")
	public Result updatePwByNickName(@PathVariable("nickname") String nickName,@RequestBody String password)
	{
		return customerService.updatePwByNickName(nickName, password);
	}
	
	@DeleteMapping("/allDelete")
	public Result deleteAllCustomer() {
		return customerService.deleteAllCustomer();
	}
	
	@DeleteMapping("/delete/{nickname}/")
	public Result deleteCustomerByNickName(@PathVariable("nickname") String nickName) {
		return customerService.deleteCustomerByNickName(nickName);
	}
	
	@GetMapping("/{nickname}/Adress")
	public DataResult<List<Adress>> getAdressByNickName(@PathVariable("nickname") String nickName)
	{
		return customerService.getAdressByNickName(nickName);
	}
	
	@PostMapping("/{nickname}/update-adress")
	    public Result updateAdressByNickName(@PathVariable("nickname")String nickName,@RequestBody List<Adress> adress)
	    {
	        return customerService.updateAdressByNickName(nickName,adress);
	    }
	
	@PostMapping("/sign-up")
    public void signUp(@RequestBody CustomerDTO customerDTO) {
		//customerDTO.setPassword(bCryptPasswordEncoder.encode(customerDTO.getPassword()));
        customerService.save(customerDTO);
    }
	
}
