

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
	
	int order_id;
	Date delivery_date;
	String customer_name, customer_address;
	
	public Order(ResultSet rs) throws SQLException {
		order_id = rs.getInt(Database.KEYWORD_ORDER_ID);
		delivery_date = rs.getDate(Database.KEYWORD_DELIVERY_DATE);
		customer_name = rs.getString(Database.KEYWORD_CUSTOMER_NAME);
		customer_address = rs.getString(Database.KEYWORD_CUSTOMER_ADDRESS);
	}
	public int getOrder_id() {
		return order_id;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public String getCustomer_name() {
		return customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}

	

}
