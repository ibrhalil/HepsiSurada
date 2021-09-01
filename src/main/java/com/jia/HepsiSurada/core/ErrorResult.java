package com.jia.HepsiSurada.core;


public class ErrorResult extends Result
{
	public ErrorResult() 
	{
		super(false);
	}

	public ErrorResult(String mesaj) 
	{
		super(false, mesaj);
	}

}