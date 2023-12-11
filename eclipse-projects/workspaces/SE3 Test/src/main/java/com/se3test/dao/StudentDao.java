package com.se3test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.se3test.business.Enrolment;
import com.se3test.business.Student;
import com.se3test.exceptions.DaoException;


public class StudentDao extends Dao {

	final String INSERT_STUDENT = 
			"INSERT INTO STUDENT(NUMBER, FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?,?)";
	
    public void addStudent(Student student) throws DaoException {

    	Connection con = null;
        PreparedStatement ps = null;
                    
        try {
        	con = this.getConnection();
        	
        	ps = con.prepareStatement(INSERT_STUDENT);
        	ps.setString(1, student.getStudentNumber());
        	ps.setString(2, student.getFirstName());
        	ps.setString(3, student.getLastName());
        	ps.setString(4, student.getEmailAddress());
        	
        	ps.execute();
        	
        	EnrolmentDao enrolmentDao = new EnrolmentDao();
        	
        	for (Enrolment e : student.getEnrolments()) {
        		enrolmentDao.addEnrolment(e); // adds all enrolments present within the Student object. 
        	}
            
        } catch (SQLException e) {
            throw new DaoException("addStudent " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("addStudent " + e.getMessage());
            }
        }     
        
    }
   
}
