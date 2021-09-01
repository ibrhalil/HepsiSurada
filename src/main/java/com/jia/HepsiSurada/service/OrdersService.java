package com.jia.HepsiSurada.service;

import java.util.List;

import com.jia.HepsiSurada.core.DataResult;
import com.jia.HepsiSurada.core.Result;
import com.jia.HepsiSurada.model.Basket;
import com.jia.HepsiSurada.model.Orders;

public interface OrdersService {
    DataResult<List<Orders>> sortedList(String type, String value);
    Result addOrders(Basket basket);
}
