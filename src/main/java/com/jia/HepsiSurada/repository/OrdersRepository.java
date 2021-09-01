package com.jia.HepsiSurada.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jia.HepsiSurada.model.Orders;

public interface OrdersRepository extends MongoRepository<Orders, UUID>{

}
