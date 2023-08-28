package com.example.cart.service.impl;

import com.example.cart.model.Cart;
import com.example.cart.repository.CartRepository;
import com.example.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;


    @Override
    public Cart getMyCart(Long id) {
        Optional<Cart> optCart = cartRepository.findById(id);
        if (optCart.isPresent()) {
            return optCart.get();
        } else {
            return null;
        }
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> addAll(List<Cart> carts) {
        return cartRepository.saveAll(carts);
    }

    @Override
    public Cart updateCart(Long id ,Cart cart) {
        Optional<Cart> OptCart = cartRepository.findById(id);
        if (OptCart.isPresent()) {
            Cart cart1 = OptCart.get();
            cart1.setName(cart.getName());
            cart1.setCount(cart.getCount());
            return cartRepository.save(cart1);
        } else {
            log.info("Employee id not Found");
            return null;
        }
    }

    @Override
    public Cart deleteCart(Long id) {
        try {
            Optional<Cart> cartToDelete = cartRepository.findById(id);
            if (cartToDelete.isPresent()) {
                cartRepository.deleteById(id);
                log.info("Cart with ID {} deleted successfully", id);
                return cartToDelete.get(); // Return the deleted cart
            } else {
                log.warn("Cart with ID {} not found for deletion", id);
                return null; // Indicate that the cart was not found
            }
        } catch (Exception e) {
            log.error("Error occurred while deleting Cart with ID {}: {}", id, e.getMessage(), e);
            return null; // Indicate failure
        }
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

}