package com.zaid.blog_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaid.blog_management_system.dao.BlogDaoInterface;
import com.zaid.blog_management_system.request.Blog;

@Service
public class BlogServiceImplementation implements BlogServiceInterface {
	
	@Autowired
	private BlogDaoInterface blogDaoInterface;

	@Override
	public Blog createBlog(Blog blog) {
		return blogDaoInterface.createBlog(blog);
		 
	}

	@Override
	public Blog getBlogById(Long id) {
		return blogDaoInterface.getBlogById(id);
		 
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogDaoInterface.getAllBlogs();
		 
	}

	
	@Override
	public Blog updateBlog(Long id, Blog blog) {
		return  blogDaoInterface.updateBlog(id,blog);
		
	}

	@Override
	public Blog deleteBlog(Long id) {
		return blogDaoInterface.deleteBlog(id); 
		
	}

	

	
}
