package com.zaid.blog_management_system.service;

import java.util.List;

import com.zaid.blog_management_system.request.Blog;

public interface BlogServiceInterface {

	Blog createBlog(Blog blog);
	
	Blog getBlogById(Long id);

	List<Blog> getAllBlogs();


	Blog deleteBlog(Long id);

	Blog updateBlog(Long id, Blog blog);

	
}
