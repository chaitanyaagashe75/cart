package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cart")
public class CartController {

    @Autowired
     public CartService cartService;

    @PostMapping("/add")
    public Cart addCarItems(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }
    @PostMapping("/addAll")
    public List<Cart> addAllCart(@RequestBody List<Cart> carts){
        return cartService.addAll(carts);
    }
    @GetMapping("/get/{id}")
    public Cart getMyCart(@PathVariable Long id){
       return cartService.getMyCart(id);
    }

    @PutMapping("/update/{id}")
    public Cart updateCart( @PathVariable Long id, @RequestBody Cart cart){
        return cartService.updateCart(id,cart);
    }

    @DeleteMapping("/delete/{id}")
    public Cart deleteCart(@PathVariable Long id){
        return cartService.deleteCart(id);
    }

    @GetMapping("/getAll")
    public List<Cart> getAllCarts(){
           return cartService.getAllCarts();
        }
        // gitu
     // changes made in local master
    }

