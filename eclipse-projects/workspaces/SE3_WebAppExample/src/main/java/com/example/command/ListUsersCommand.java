package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;
import java.util.List;

public class ListUsersCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
			
		UserService userService = new UserService();
		String forwardToJsp = "";		

		//Make call to the 'Model' using the UserServive class to get all users...
		List<User> all_users = userService.getAllUsers();

	
		HttpSession session = request.getSession();
		session.setAttribute("allUsers", all_users);

		forwardToJsp = "/listUsers.jsp";				
		
		return forwardToJsp;
	}

}
