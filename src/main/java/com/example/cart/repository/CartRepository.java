package com.example.cart.repository;

import com.example.cart.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart,Long> {

   // public Optional<Cart> findById(int id);


}
