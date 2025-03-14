package com.zaid.blog_management_system.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zaid.blog_management_system.repo.BlogRepository;
import com.zaid.blog_management_system.request.Blog;


@Component
public class BlogDaoImplementation implements BlogDaoInterface {
	
	@Autowired
	private BlogRepository blogRespository;

	@Override
	public Blog createBlog(Blog blog) {
		return blogRespository.save(blog);
		 
	}
	
	@Override
	public Blog getBlogById(Long id) {
		return  blogRespository.findById(id).orElse(null);
		
	}
	

	@Override
	public List<Blog> getAllBlogs() {
		return blogRespository.findAll();
		
	}

	@Override
	public Blog updateBlog(Long id, Blog blog) {
		Blog blogFetchedById = blogRespository.findById(id).orElse(null);
		if(blogFetchedById!=null) {
			if(blog.getContent()!=null) {
			blogFetchedById.setContent(blog.getContent());
			}
			if(blog.getTitle()!=null) {
			blogFetchedById.setTitle(blog.getTitle());
			}
			return  blogRespository.save(blogFetchedById);
			
			
		}else {
			return null;
			
		}
	}

	@Override
	public Blog deleteBlog(Long id) {
		blogRespository.deleteById(id);
		return  blogRespository.findById(id).orElse(null);
		
		
	}

	

}
