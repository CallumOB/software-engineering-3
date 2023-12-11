package com.se3test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.se3test.exceptions.DaoException;
import com.se3test.business.Module;

public class ModuleDao extends Dao{

	final String GET_MODULE_BY_CODE = "SELECT * FROM MODULE WHERE CODE = ?";

	
    public Module getModuleByCode(String code) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Module module = null;
        
        try {
        	con = this.getConnection();
        	
        	ps = con.prepareStatement(GET_MODULE_BY_CODE);
        	ps.setString(1, code);
        	
        	rs = ps.executeQuery();
        	if (rs.next()) {
        		String moduleCode = rs.getString("CODE");
        		String moduleTitle = rs.getString("TITLE");
        		module = new Module(moduleCode, moduleTitle);
        	}
        } catch (SQLException e) {
            throw new DaoException("getModuleByCode " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close(); 
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("getModuleByCode " + e.getMessage());
            }
        }
        return module;
    }
	
	
}
