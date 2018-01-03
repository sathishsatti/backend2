package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blogpostlikes_USERS")
public class BlogPostLikes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

//@ManyToOne
private UsersDetails usersDetails;
public UsersDetails getUsersDetails() {
	return usersDetails;
}
public void setUsersDetails(UsersDetails usersDetails) {
	this.usersDetails = usersDetails;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

//@ManyToOne
private BlogPost blogPost;

public BlogPost getBlogPost() {
	return blogPost;
}
public void setBlogPost(BlogPost blogPost) {
	this.blogPost = blogPost;


}}