package com.se3test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.se3test.business.Enrolment;
import com.se3test.exceptions.DaoException;

public class EnrolmentDao extends Dao{

	final private String INSERT_ENROLMENT = 
			"INSERT INTO ENROLMENT(DATE_ENROLLED, MODULE_CODE, STUDENT_NUMBER) VALUES (?,?,?)";

	
    public void addEnrolment(Enrolment enrolment) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
                    
        try {
        	con = this.getConnection();
        	
            ps = con.prepareStatement(INSERT_ENROLMENT);
            ps.setString(1, enrolment.getEnrolmentDate().toString());
            ps.setString(2, enrolment.getModule().getModuleCode());
            ps.setString(3, enrolment.getStudent().getStudentNumber());
            
            ps.execute();
            
        } catch (SQLException e) {
            throw new DaoException("addEnrolment " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("addEnrolment " + e.getMessage());
            }
        }        
    }	
}
