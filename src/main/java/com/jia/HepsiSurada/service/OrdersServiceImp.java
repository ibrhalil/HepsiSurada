package com.jia.HepsiSurada.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.core.SuccessDataResult;
import com.jia.HepsiSurada.core.SuccessResult;
import com.jia.HepsiSurada.model.Basket;
import com.jia.HepsiSurada.model.Orders;
import com.jia.HepsiSurada.repository.OrdersRepository;

public class OrdersServiceImp implements OrdersService{
    
    @Autowired
    private OrdersRepository ordersRepository;
    
    @Override
    public DataResult<List<Orders>> sortedList(String type, String value) {
        Sort sort = null;
        
        switch (value) 
        {
        case "total-amount":
            if(type.equalsIgnoreCase("ASC"))
            {
                sort = Sort.by(Sort.Direction.ASC,"total-amount");
            }
            else if(type.equalsIgnoreCase("DESC"))
            {
                sort = Sort.by(Sort.Direction.DESC,"total-amount");
            }
            break;
            
        

        default:
            sort = Sort.by(Sort.Direction.ASC,"total-amount");
            break;
        }
        
        return new SuccessDataResult<List<Orders>>(ordersRepository.findAll(sort));
    }/**/

    @Override
    public Result addOrders(Basket basket) {
        Orders orders = new Orders();
        orders.setProducts(basket.getProducts());
        orders.setTotalAmount(basket.getTotalAmount());
        orders.setId(UUID.randomUUID());
        ordersRepository.save(orders);
        
        return new SuccessResult("Orders eklendi.");
    }
}
