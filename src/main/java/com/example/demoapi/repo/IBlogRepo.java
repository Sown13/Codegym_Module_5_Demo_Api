package com.example.demoapi.repo;

import com.example.demoapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends JpaRepository<Blog,Long> {
}
