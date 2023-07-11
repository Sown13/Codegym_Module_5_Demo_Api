package com.example.demoapi.controller;

import com.example.demoapi.model.Blog;
import com.example.demoapi.model.Cart;
import com.example.demoapi.service.blog.IBlogService;
import com.example.demoapi.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartRestController {
    @Autowired
    public ICartService cartService;
    @GetMapping("")
    public ResponseEntity<Iterable<Cart>> listCart(){
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api")
    public ResponseEntity<Cart> findCartById(@PathVariable Long id){
        Optional<Cart> optionalBlog = cartService.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalBlog.get(),HttpStatus.OK);
    }
    @PostMapping("/api")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return new ResponseEntity<>(cartService.save(cart),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void removeCart(@PathVariable Long id){
        cartService.deleteById(id);
    }
    @PutMapping("/api/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id,@RequestBody Cart cart){
        Optional<Cart> optionalBlog = cartService.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cart.setCartId(id);
        return new ResponseEntity<>(cartService.save(cart),HttpStatus.OK);
    }
}
