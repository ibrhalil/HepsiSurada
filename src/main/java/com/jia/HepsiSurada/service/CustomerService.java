package com.jia.HepsiSurada.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.CustomerLoginDTO;
import com.jia.HepsiSurada.model.Adress;
import com.jia.HepsiSurada.model.Customer;

@Service
public interface CustomerService {


	public DataResult<Customer> getCustomerByNickName(String nickName);

	//public Result addCustomer(CustomerDTO customerDTO);
	
	public Result updateCustomerByNickName(String nickName,CustomerDTO customerDTO);
	
	public Result updatePwByNickName(String nickName, String password);
	  
	public Result deleteAllCustomer();
	
	public Result deleteCustomerByNickName(String nickName);
	
	public DataResult<List<Adress>> getAdressByNickName(String nickName);

	Result updateAdressByNickName(String nickName, List<Adress> adress);

	DataResult<List<Customer>> getListCustomer();

	public void save(CustomerDTO customerDTO);
	
	public void checkUser(CustomerLoginDTO customerLoginDTO);

	//public DataResult<List<Orders>> getOrdersByNickName(String nickName, List<Orders> orders);
	
}
