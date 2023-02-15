package com.urbankicks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.urbankicks.entities.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    @Query(value="select * from cart_item where user_id =:id", nativeQuery=true)
	public List<CartItem> getCartItemsByUser(@Param("id")int id);
    
    
}
