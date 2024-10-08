package com.se3test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.se3test.command.Command;
import com.se3test.command.CommandFactory;
import com.se3test.exceptions.CommandCreationException;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns={"/FrontController"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String LOGIN_ACTION = "LoginUser";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest (request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}	
	
	
	/**
	 * Common method to process all client requests (GET and POST)
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {

		String nextView = null;		
		String action = request.getParameter("action");
		
		
		/*
		 * NOTE: AS A SPCIAL CASE, THIS SECTION OF THE CODE DEALS WITH CHECKING LOGIN DETAILS...
		 */
		
		//Check if this is not a login request...
//		if ( !action.equalsIgnoreCase(LOGIN_ACTION) ){
//
//			//If not a login request then need to check that user is  
//			//logged in before processing ANY requests.
//			
//			//Check to see if the session id coming from the client matches the id stored at login...
//			HttpSession session = request.getSession();
//
//			//If user not logged in...
//			if ( session.getId() != session.getAttribute("loggedSessionId") ){
//				nextView = "/loginFailure.jsp";
//				dispatchToView(request, response, nextView);
//				return;
//			}			
//		}			
		
		
		//Now we can process whatever the request is...
		//We just create a Command object to handle the request...
		CommandFactory factory = CommandFactory.getInstance();
		Command command = null;
		
		try {
			command = factory.createCommand(action);
			nextView = command.execute(request, response);
		} catch (CommandCreationException e) {			
			e.printStackTrace();
			nextView = "/errorPage.jsp";
		}		
		
		dispatchToView(request, response, nextView);
	}
	
	
	/**
	 * Forward to server to the supplied page
	 */
	private void dispatchToView(HttpServletRequest request, HttpServletResponse response, String page){
		
		//Get the request dispatcher object and forward the request to the appropriate JSP page...
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
