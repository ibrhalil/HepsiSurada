package com.jia.HepsiSurada.core;

public class SuccessResult extends Result
{
	public SuccessResult() 
	{
		super(true);
	}
	
	public SuccessResult(String mesaj) 
	{
		super(true,mesaj);
	}

}
