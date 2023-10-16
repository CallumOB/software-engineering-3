import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLCustomerDao implements CustomerDao {
	
	private Connection getConnection() {
		Connection conn = null; 
		
		try {
			conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test", "root", "" ) ;			
		} catch (SQLException se) {
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		
		return conn;
	}
	
	public List<Customer> selectCustomersByName(String name) {
		Connection conn = getConnection();
		List<Customer> customerList = new ArrayList<>();
		
		if (conn != null) {
			try {
				// Get a statement from the connection
				Statement stmt = conn.createStatement() ;
				
				// Execute the query
				ResultSet rs = stmt.executeQuery( "SELECT * FROM customer where customerName like '%" + name + "%' order by customerName" ) ;
				
				// Loop through the result set
				while( rs.next() ) {	
					customerList.add(getCustomerFromDB(rs));
				}

				// Close the result set, statement and the connection
				rs.close() ;
				stmt.close() ;
				conn.close() ;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customerList;
	}
	
	public Customer findCustomerById(int customerNumber) {
		Connection conn = getConnection();
		Customer customerResult = null;
		if (conn != null) {
			try {
				// Get a statement from the connection
				Statement stmt = conn.createStatement() ;
				
				// Execute the query
				ResultSet rs = stmt.executeQuery( "SELECT * FROM customer where customerNumber = " + customerNumber) ;
				
				// Loop through the result set
				customerResult = getCustomerFromDB(rs);

				// Close the result set, statement and the connection
				rs.close() ;
				stmt.close() ;
				conn.close() ;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customerResult;
	}
	
	public void updateCustomer(int customerNumber, int value) {
		Connection conn = getConnection();
		
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				int rowsUpdated = stmt.executeUpdate("UPDATE Customer SET creditLimit = " + value + " WHERE customerNumber = " + customerNumber);
				
				System.out.println("Rows Updated: " + rowsUpdated);
				
				stmt.close();
				conn.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Customer getCustomerFromDB(ResultSet rs) {
		Customer newCustomer = null;
		try {	
			rs.next();
			double creditLimit = rs.getInt("creditLimit");
			int salesRepEmployeeNumber = rs.getInt("salesRepEmployeeNumber");
			String country = rs.getString("country");
			String postalCode = rs.getString("postalCode");
			String state = rs.getString("state");
			String city = rs.getString("city");
			String addressLine2 = rs.getString("addressLine2");
			String addressLine1 = rs.getString("addressLine1");
			String phone = rs.getString("phone");
			String contactFirstname = rs.getString("contactFirstName");
			String customerName = rs.getString("customerName");
			String contactLastName = rs.getString("contactLastName");
			int customerNumber = rs.getInt("customerNumber");
			
			newCustomer = new Customer(creditLimit, salesRepEmployeeNumber, country, postalCode, state, city, addressLine2, addressLine1, phone, contactFirstname, customerName, contactLastName, customerNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newCustomer;
	}
}
