package com.example.demoapi.controller;

import com.example.demoapi.model.Blog;
import com.example.demoapi.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    public IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> listBlog(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api")
    public ResponseEntity<Blog> findById(@PathVariable Long id){
        Optional<Blog> optionalBlog = blogService.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalBlog.get(),HttpStatus.OK);
    }
    @PostMapping("/api")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        blogService.deleteById(id);
    }
    @PutMapping("/api/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id,@RequestBody Blog blog){
        Optional<Blog> optionalBlog = blogService.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setBlogId(id);
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.OK);
    }
}
