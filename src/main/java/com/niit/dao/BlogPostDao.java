package com.niit.dao;



import java.util.List;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;


public interface BlogPostDao{
	
	public boolean createBlogPost(BlogPost post);
	List<BlogPost> list(int approved);
	public List<BlogPost> findLatest5Post();
	public BlogPost findPostById(int id);
	void updateBlogPost(BlogPost blogPost);
	public void deleteById(int id);
	List<BlogComment> getBlogComments(int blogId);
	void addBlogComment(BlogComment blogComment);
	


}
