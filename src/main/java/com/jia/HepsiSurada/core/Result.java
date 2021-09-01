package com.jia.HepsiSurada.core;

public class Result 
{
	private boolean durum;
	private String mesaj;
	
	public Result(boolean durum) 
	{
		this.durum = durum;
	}
	
	public Result(boolean durum, String mesaj) 
	{
		this.durum = durum;
		this.mesaj = mesaj;
	}

	public boolean isDurum() {
		return durum;
	}

	public String getMesaj() {
		return mesaj;
	}
	
}
