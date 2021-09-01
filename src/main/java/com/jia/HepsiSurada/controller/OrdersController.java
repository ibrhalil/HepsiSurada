package com.jia.HepsiSurada.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.model.Basket;
import com.jia.HepsiSurada.model.Orders;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired
	private OrdersController ordersService;
		
    	@PostMapping("/add")
    	public Result addOrders(@RequestBody Basket basket) {
        return ordersService.addOrders(basket);
    	}
		@GetMapping("/all")
		public DataResult<List<Orders>> getListOrders(){
			return ordersService.getListOrders();		
		}
		
		@GetMapping("/{user-id}")
		public DataResult<Orders> getOrders(@PathVariable("user-id") UUID id)
		{
			return ordersService.getOrders(id);
		}
		@GetMapping("/sort")
		public Result sortedList(String type, String value)
		{
			return ordersService.sortedList(type,value);
		}
	/**/	
}