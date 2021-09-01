package com.jia.HepsiSurada.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress 
{
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(min = 3, max = 50, message = "3 ile 50 karakter arası olmalıdır.")
	private String country;
	
	@NotNull(message = "Boş Bırakmayınız.")
	@Size(min = 3, max = 50, message = "3 ile 50 karakter arası olmalıdır.")
	private String city;
	
	private String district;
}
