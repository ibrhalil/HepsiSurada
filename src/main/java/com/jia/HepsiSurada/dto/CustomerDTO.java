package com.jia.HepsiSurada.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	
	private String nickName;
	
	private String name;
	
	private String surname;
	
	private String mail;
	
	private String password;
}
