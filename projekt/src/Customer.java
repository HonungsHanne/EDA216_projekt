

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	String customer_name, customer_address;
	
	public Customer(ResultSet rs) throws SQLException {
		customer_name = rs.getString(Database.KEYWORD_CUSTOMER_NAME);
		customer_address = rs.getString(Database.KEYWORD_CUSTOMER_ADDRESS);
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}

}