package com.niit.Dao;

import java.util.List;

import com.niit.model.UsersDetails;



public interface UsersDAO {
	
	public boolean saveOrUpdate(UsersDetails users);
	public UsersDetails updateUser(UsersDetails users);
	public void delete(UsersDetails user);
	public UsersDetails getUser(String username);
	public UsersDetails viewUser(int userid);
	public List<UsersDetails> UserList();
	public UsersDetails login(UsersDetails user);
	public boolean isUsernameValid(String username);
	public boolean isEmailValid(String email);
	public UsersDetails getUserByUsername(String username);
}