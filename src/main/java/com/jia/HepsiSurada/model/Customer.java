package com.jia.HepsiSurada.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer 
{
	@Id
	@Column(name = "customer_id")
	private UUID id;
	
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	@Column(name = "customer_nickname")
	private String nickName;
	
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	@Column(name = "customer_name")
	private String name;
	
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	@Column(name = "customer_surname")
	private String surname;
	
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name = "customer_mail")
	private String mail;
	
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(max = 100, message = "100 karakterden fazla girmeyiniz.")
	@Column(name = "customer_password")
	private String password;
	
	@ElementCollection
	@CollectionTable(name = "customer_adresses", joinColumns = @JoinColumn(name = "customer_id"))
	private List<Adress> adresses;
}
