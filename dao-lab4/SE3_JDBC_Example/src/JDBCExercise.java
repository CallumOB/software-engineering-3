import java.util.ArrayList;
import java.util.List;

public class JDBCExercise {
	public static void main(String args[]) {
		CustomerDao sqlDAO = new MySQLCustomerDao();
		Customer result1 = null;
		List<Customer> result2 = new ArrayList<>();;
		
		result1 = sqlDAO.findCustomerById(347);
		System.out.println(result1);
		
		result2 = sqlDAO.selectCustomersByName("Mini");
		System.out.println(result2);
	}
}
