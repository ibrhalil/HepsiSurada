package com.jia.HepsiSurada.core;


public class DataResult<T> extends Result
{
	private T data;
	
	public DataResult(T data, boolean durum) 
	{
		super(durum);
		this.data = data;
	}
	
	public DataResult(T data, boolean durum, String message) 
	{
		super(durum,message);
		this.data = data;		
	}

	public T getData() 
	{
		return data;
	}

}