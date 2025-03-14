package com.zaid.blog_management_system.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zaid.blog_management_system.request.Blog;


@Component
public class BlogResponse {

	private Boolean error;
	private String msg;
	private List<Blog> blogs;
	
	
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
	
	
	
	
}
