package com.se3test.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se3test.business.Module;
import com.se3test.business.Student;
import com.se3test.dao.ModuleDao;
import com.se3test.dao.StudentDao;
import com.se3test.exceptions.DaoException;


public class AddStudentCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
			
		String studentNumber = request.getParameter("studentNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String[] moduleCodes = request.getParameterValues("modules");
		
		String nextView = "/errorView.jsp";
		ModuleDao moduleDao = new ModuleDao();
		List<Module> modules = new ArrayList<>();
		
		/* the string array of module codes is not of the type needed to create a student object,
		 * so I loop through all modules present in the DB using the codes given from the String array,
		 * and add those modules to an ArrayList to be passed into the constructor of the Student object. 
		 */
		try {
			for (String code : moduleCodes) {
				modules.add(moduleDao.getModuleByCode(code));
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		Student s = new Student(studentNumber, firstName, lastName, emailAddress, modules);
		
		
		// Once the student object has been created, I can loop through the module list and create an enrolment for each module. 
		for (Module m : modules) {
			s.enrol(m);
		}
		
		StudentDao studentDao = new StudentDao();
		
		/* this call to the DB adds the student object to the DB as well as looping through all enrolments 
		 * and adding each to the enrolment table. this is done within StudentDao using EnrolmentDao. 
		 */
		try {
			studentDao.addStudent(s);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		// upon success, return to the addStudentView page.
		nextView = "/addStudentView.jsp";
		
		return nextView;
	}

}
