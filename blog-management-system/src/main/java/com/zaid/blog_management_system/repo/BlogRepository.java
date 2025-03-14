package com.zaid.blog_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zaid.blog_management_system.request.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
