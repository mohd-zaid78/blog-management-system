package com.zaid.blog_management_system.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaid.blog_management_system.openAIservice.AiService;
import com.zaid.blog_management_system.request.Blog;
import com.zaid.blog_management_system.response.BlogResponse;
import com.zaid.blog_management_system.service.BlogServiceInterface;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {

	@Autowired
	private BlogServiceInterface blogServiceInterface;
	@Autowired
	private BlogResponse blogResponse;

	@Autowired
	private AiService aiService;


	@PostMapping
	public ResponseEntity<BlogResponse> addBlog(@RequestBody Blog blog) {
		Blog blogSaved = blogServiceInterface.createBlog(blog);
		if (blogSaved != null) {
			blogResponse.setError(false);
			blogResponse.setMsg("blog added succesfully");
			blogResponse.setBlogs(Arrays.asList(blog));
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);
		} else {
			blogResponse.setError(true);
			blogResponse.setMsg("blog failed to add");
			blogResponse.setBlogs(null);
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<BlogResponse> getById(@PathVariable("id") Long id) {
		Blog fetchedBlogById = blogServiceInterface.getBlogById(id);
		if (fetchedBlogById != null) {
			blogResponse.setError(false);
			blogResponse.setMsg("fetch successfully");
			blogResponse.setBlogs(Arrays.asList(fetchedBlogById));
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);

		} else {
			blogResponse.setError(true);
			blogResponse.setMsg("failed to fetch");
			blogResponse.setBlogs(null);
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<BlogResponse> getAllBlogs() {

		List<Blog> fetchedAllBlogs = blogServiceInterface.getAllBlogs();
		if (fetchedAllBlogs != null && !fetchedAllBlogs.isEmpty()) {
			blogResponse.setError(false);
			blogResponse.setMsg("fetched all blogs successfully");
			blogResponse.setBlogs(fetchedAllBlogs);
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);
			

		}else if(fetchedAllBlogs != null && fetchedAllBlogs.isEmpty()) {
			blogResponse.setError(false);
			blogResponse.setMsg("there is no blog present");
			blogResponse.setBlogs(fetchedAllBlogs);
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);
		} else {
			blogResponse.setError(true);
			blogResponse.setMsg("failed to fetch blogs");
			blogResponse.setBlogs(null);
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<BlogResponse> update(@PathVariable(name="id") Long id, @RequestBody Blog blog) {
		Blog blogUpdated = blogServiceInterface.updateBlog(id, blog);
		if (blogUpdated != null) {
			blogResponse.setError(false);
			blogResponse.setMsg("blog updated successfully");
			blogResponse.setBlogs(Arrays.asList(blogUpdated));
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);

		} else {
			blogResponse.setError(true);
			blogResponse.setMsg("failed to update blog");
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BlogResponse> deleteBlog(@PathVariable("id") Long id) {
		Blog blogDeleted = blogServiceInterface.deleteBlog(id);
		if (blogDeleted == null) {
			blogResponse.setError(false);
			blogResponse.setMsg("deleted successfully");
			blogResponse.setBlogs(null);
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);
		} else {
			blogResponse.setError(true);
			blogResponse.setMsg("failed to delete");
			blogResponse.setBlogs(Arrays.asList(blogDeleted));
			return new ResponseEntity<BlogResponse>(blogResponse, HttpStatus.OK);

		}

	}
	
	
	
	
	

	@GetMapping("/{id}/summary")
	public ResponseEntity<String> summarizeBlog(@PathVariable("id") Long id) {
	    Blog blog = blogServiceInterface.getBlogById(id);
	    if (blog != null) {
	        String summary = aiService.summarizeText(blog.getContent());
	        return ResponseEntity.ok(summary);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Blog not found");
	    }
	}

	
	
	
	}
