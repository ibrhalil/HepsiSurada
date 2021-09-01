package com.jia.HepsiSurada.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.core.SuccessDataResult;
import com.jia.HepsiSurada.core.SuccessResult;
import com.jia.HepsiSurada.dto.CustomerDTO;
import com.jia.HepsiSurada.dto.CustomerLoginDTO;
import com.jia.HepsiSurada.model.Adress;
import com.jia.HepsiSurada.model.Customer;
import com.jia.HepsiSurada.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
   
	@Override
    public DataResult<List<Customer>> getListCustomer() {
        return new SuccessDataResult<List<Customer>>(customerRepository.findAll(),"Müşteri listesi döndürüldü.");
    }

    @Override
    public DataResult<Customer> getCustomerByNickName(String nickName) {
        return new SuccessDataResult<Customer>(customerRepository.getCustomerBynickName(nickName),"Kullanıcı adı verilen kullanıcı döndürüldü.");
    }
/*
    @Override
    public Result addCustomer(CustomerDTO customerDTO) {
        Optional<Customer> newCustomer= customerRepository.getCustomerByNickName(customerDTO.getNickName());
        if(newCustomer.isPresent())
        {
            throw new RuntimeErrorException(null,"NickName mevcuttur.");
        }
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setNickName(customerDTO.getNickName());
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setSurname(customerDTO.getSurname());
        customerRepository.save(customer);
        return new SuccessResult("Müşteri eklendi.");
    }
*/
    @Override
    public Result updateCustomerByNickName(String nickName, CustomerDTO customerDTO) {
        Customer newCustomer = customerRepository.getCustomerBynickName(nickName);
        newCustomer.setMail(customerDTO.getMail());
        newCustomer.setName(customerDTO.getName());
        newCustomer.setSurname(customerDTO.getSurname());
        customerRepository.save(newCustomer);
        return new SuccessResult("Bilgiler güncellendi.");
    }

    @Override
    public Result updatePwByNickName(String nickName, String password) {
        Customer newCustomer = customerRepository.getCustomerBynickName(nickName);
        newCustomer.setPassword(bCryptPasswordEncoder.encode(password));
        customerRepository.save(newCustomer);
        return new SuccessResult("Kullanıcının şifresi değiştirildi.");
    }

    @Override
    public Result deleteAllCustomer() {
        customerRepository.deleteAll();
        return new SuccessResult("Tüm kullanıcılar silindi.");
    }

    @Override
    public Result deleteCustomerByNickName(String nickName) {
        customerRepository.deleteCustomerBynickName(nickName);
        return new SuccessResult("Kullanıcı silindi.");
    }

    @Override
    public DataResult<List<Adress>> getAdressByNickName(String nickName) {
        Customer newCustomer = customerRepository.getCustomerBynickName(nickName);
        
        return new SuccessDataResult<List<Adress>>(newCustomer.getAdresses(),"Kullanıcının adresi döndürüldü.");
    }

    @Override
    public Result updateAdressByNickName(String nickName, List<Adress> adress) {
        Customer newCustomer = customerRepository.getCustomerBynickName(nickName);
        newCustomer.setAdresses(adress);
        customerRepository.save(newCustomer);
        return null;

}

	@Override
	public void save(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setId(UUID.randomUUID());
		customer.setSurname(customerDTO.getSurname());
		customer.setMail(customerDTO.getMail());
		customer.setName(customerDTO.getName());
		customer.setNickName(customerDTO.getNickName());
		customer.setPassword(bCryptPasswordEncoder.encode(customerDTO.getPassword()));
        customerRepository.save(customer);
		
	}

	@Override
	public void checkUser(CustomerLoginDTO customerLoginDTO) {
		Customer customer = customerRepository.findByMail(customerLoginDTO.getMail());
		if(!Objects.isNull(customer) && bCryptPasswordEncoder.matches(customerLoginDTO.getPassword(), customer.getPassword())) {
			System.out.print("sdad");
		}
		else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Şifre veya mail hatalı");
		}
		
		
	}

}
