package com.example.service;

import com.example.business.User;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;
import java.util.List;
import java.util.ArrayList;

public class UserService {

	UserDao dao = new UserDao();
	
	public User login(String username, String password){
		
		User u = null;
		try {			
			u = dao.findUserByUsernamePassword(username, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	public List<User> getAllUsers() {
		List<User> user_list = new ArrayList<>();
		
		try {
			user_list = dao.getAllUsers();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		return user_list;
	}
	
}
