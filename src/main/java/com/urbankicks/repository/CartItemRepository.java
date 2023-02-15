package com.urbankicks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.urbankicks.entities.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    @Query(value="select * from cart_item where user_id =:id", nativeQuery=true)
	public List<CartItem> getCartItemsByUser(@Param("id")int id);

    @Query(value="select * from cart_item where cart_item_id =:id", nativeQuery=true)
    public CartItem findById(@Param("id") int id);

    @Query(value="delete from cart_item where cart_item_id =:id", nativeQuery=true)
    public CartItem deleteById(@Param("id") int id);
    
}
