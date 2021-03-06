
import java.sql.ResultSet;
import java.sql.SQLException;

public class PalletOrder {
	int pallet_order_id, order_id, amount;
	String recipe_name;
	
	
	public PalletOrder(ResultSet rs) throws SQLException {
		amount = rs.getInt(Database.KEYWORD_AMOUNT);
		order_id = rs.getInt(Database.KEYWORD_ORDER_ID);
		pallet_order_id = rs.getInt(Database.KEYWORD_PALLET_ORDER_ID);
		recipe_name = rs.getString(Database.KEYWORD_RECIPE_NAME);
	}
	
	public String getRecipe_name() {
		return recipe_name;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public int getPallet_order_id() {
		return pallet_order_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	
}
