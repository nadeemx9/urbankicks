package com.urbankicks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbankicks.entities.Orders;
import com.urbankicks.repository.OrdersRepository;

@Service
public class OrdersService  {
    @Autowired
    private OrdersRepository ordersRepository;

    public void placeOrder(Orders order)
    {
        ordersRepository.save(order);
    }
}
