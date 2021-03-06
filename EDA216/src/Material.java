

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Material {
	String material_name;
	String timestamp;
	double amount;
	
	public Material(ResultSet rs) throws SQLException {
		amount = rs.getDouble(Database.KEYWORD_AMOUNT);
		material_name = rs.getString(Database.KEYWORD_MATERIAL_NAME);
		timestamp = rs.getString(Database.KEYWORD_TIMESTAMP);
	}
	
	public double getAmount() {
		return amount;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public String getTimestamp() {
		return timestamp;
	}
	
}
