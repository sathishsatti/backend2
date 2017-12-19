package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Dao.UsersDAO;
import com.niit.model.UsersDetails;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersDAO usersDAO;


	public boolean saveOrUpdate(UsersDetails users) {

		return usersDAO.saveOrUpdate(users);
	}

	public void delete(UsersDetails user) {
		usersDAO.delete(user);
		
	}

	public UsersDetails getUser(String username) {
		return usersDAO.getUser(username);
	}

	public UsersDetails viewUser(int userid) {
		
		return usersDAO.viewUser(userid);
	}

	public List<UsersDetails> UserList() {
	
		return usersDAO.UserList();
	}

	public UsersDetails login(UsersDetails user) {
		
		return usersDAO.login(user);
	}

	public boolean isUsernameValid(String username) {
	
		return usersDAO.isUsernameValid(username);
	}

	public boolean isEmailValid(String email) {
	
		return usersDAO.isEmailValid(email);
	}

	public UsersDetails updateUser(UsersDetails users) {

		return usersDAO.updateUser(users);
	}

	
	
}