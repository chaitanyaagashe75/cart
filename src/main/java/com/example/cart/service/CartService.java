package com.example.cart.service;

import com.example.cart.model.Cart;

import java.util.List;

public interface CartService {


    public Cart getMyCart(Long id) ;

    public Cart addCart(Cart cart);

    public  List<Cart> addAll(List<Cart> carts);

    public Cart updateCart(Long id ,Cart cart);

   public Cart deleteCart(Long id);


    public List<Cart> getAllCarts();
}
