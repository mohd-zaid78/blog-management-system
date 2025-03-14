package com.zaid.blog_management_system.request;

import java.time.LocalDateTime;



import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String author;
	@Column(updatable = false) 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss a")
	private LocalDateTime createdAt;
	
	
	public Blog(long id, String title, String content, String author, LocalDateTime createdAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdAt = createdAt;
	}
	
	public Blog() {
	    
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(); 
    }

    
    @PreUpdate
    protected void onUpdate() {
        this.createdAt = LocalDateTime.now(); 
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
	
	
	
	
}
