package com.example.demoapi.controller;

import com.example.demoapi.model.Blog;
import com.example.demoapi.model.User;
import com.example.demoapi.service.blog.IBlogService;
import com.example.demoapi.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserRestController {
    @Autowired
    public IUserService userService;
    @GetMapping("")
    public ResponseEntity<Iterable<User>> listUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        Optional<User> optionalUser = userService.findById(id);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalUser.get(),HttpStatus.OK);
    }
    @PostMapping("/api")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id){
        userService.deleteById(id);
    }
    @PutMapping("/api/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        Optional<User> optionalUser = userService.findById(id);
        if (!optionalUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setUserId(id);
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }
}
