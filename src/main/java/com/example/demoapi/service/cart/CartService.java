package com.example.demoapi.service.cart;

import com.example.demoapi.model.Cart;
import com.example.demoapi.repo.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepo cartRepo;
    @Override
    public Iterable<Cart> findAll() {
        return cartRepo.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepo.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRepo.deleteById(id);
    }
}
