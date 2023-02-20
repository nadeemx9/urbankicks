package com.urbankicks.repository;
import org.springframework.data.repository.CrudRepository;
import com.urbankicks.entities.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>  {
     
}
