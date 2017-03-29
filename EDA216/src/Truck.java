

import java.sql.ResultSet;
import java.sql.SQLException;

public class Truck {
	int truck_id, pallet_order_id;
	
	public Truck(ResultSet rs) throws SQLException {
		truck_id = rs.getInt(Database.KEYWORD_TRUCK_ID);
		pallet_order_id = rs.getInt(Database.KEYWORD_PALLET_ORDER_ID);
		
	}

	public int getPallet_order_id() {
		return pallet_order_id;
	}
	
	public int getTruck_id(){
		return truck_id;
	}
}
