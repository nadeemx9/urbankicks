package com.urbankicks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.urbankicks.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Query(value="select * from cart where user_id =:id", nativeQuery=true)
	public Cart getCartByUser(@Param("id")int id);    

}

