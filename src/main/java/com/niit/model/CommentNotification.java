package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comment_Notifications")
public class CommentNotification {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String blogTitle;
	
	private String username;
	
private boolean viewedcomments;
	
	@ManyToOne
	private UsersDetails commentedBy;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isViewedcomments() {
		return viewedcomments;
	}

	public void setViewedcomments(boolean viewedcomments) {
		this.viewedcomments = viewedcomments;
	}

	public UsersDetails getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(UsersDetails commentedBy) {
		this.commentedBy = commentedBy;
	}

}