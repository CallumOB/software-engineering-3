import java.util.ArrayList;
import java.util.List;

public class JDBCExercise {
	public static void main(String args[]) {
		CustomerDao sqlDAO = new MySQLCustomerDao();
		Customer result1 = null;
		List<Customer> result2 = new ArrayList<>();
		Customer result3 = null;
		
		result1 = sqlDAO.findCustomerById(347);
		System.out.println("Result 1\n" + result1);
		
		result2 = sqlDAO.selectCustomersByName("Mini");
		System.out.println("Result 2\n" + result2);
		
		result3 = sqlDAO.findCustomerById(347);
		System.out.println(result3);
		((MySQLCustomerDao) sqlDAO).updateCustomer(347, 60000);
		result3 = sqlDAO.findCustomerById(347);
		System.out.println(result3);
		
	}
}
