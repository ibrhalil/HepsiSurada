package com.jia.HepsiSurada.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jia.HepsiSurada.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>
{
	Customer getCustomerBynickName(String nickName);
	
	Customer findByMail(String mail);
	
	Optional<Customer> getCustomerByNickName(String nickName);
	
	Customer deleteCustomerBynickName(String nickName);

//	Customer getAdressBynickName(String nickName);
//	
//	Customer updateAdressBynickName(String nickName);

}
