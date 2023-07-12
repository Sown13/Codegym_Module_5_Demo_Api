package com.example.demoapi.controller;

import com.example.demoapi.model.Blog;
import com.example.demoapi.model.Product;
import com.example.demoapi.service.blog.IBlogService;
import com.example.demoapi.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    public IProductService productService;
    @GetMapping("")
    public ResponseEntity<Iterable<Product>> listProduct(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalProduct.get(),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Product> findProductByUserId(@PathVariable Long id){
        return new ResponseEntity<>(productService.findProductByUserId(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id){
        productService.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setProductId(id);
        return new ResponseEntity<>(productService.save(product),HttpStatus.OK);
    }
}
