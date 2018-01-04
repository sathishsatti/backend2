package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.BlogPostDao;
import com.niit.model.BlogComment;
import com.niit.model.BlogPost;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	@Autowired
	private BlogPostDao blogPostDao;

	public boolean createBlogPost(BlogPost post) {
	
		return blogPostDao.createBlogPost(post);
	}

	public List<BlogPost> list(int approved) {
	
		return blogPostDao.list(approved);
	}

	public List<BlogPost> findLatest5Post() {
	
		return null;
	}

	public BlogPost findPostById(int id) {
	
		return blogPostDao.findPostById(id);
	}

	public void updateBlogPost(BlogPost blogPost){
	
	 blogPostDao.updateBlogPost(blogPost);
	}

	public void deleteById(int id) {
		blogPostDao.deleteById(id);
		
	}

	public List<BlogComment> getBlogComments(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

