package com.niit.service;

import java.util.List;

import com.niit.model.UsersDetails;

public interface UserService {
	
	public boolean saveOrUpdate(UsersDetails users);
	public UsersDetails updateUser(UsersDetails users);
	public void delete(UsersDetails user);
	public UsersDetails getUser(String username);
	public UsersDetails viewUser(int userid);
	public List<UsersDetails> UserList();
	public UsersDetails login(UsersDetails user);
	public boolean isUsernameValid(String username);
	public boolean isEmailValid(String email);

}
