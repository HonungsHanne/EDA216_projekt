

import java.sql.ResultSet;
import java.sql.SQLException;

public class Recipe {
	String recipe_name, material_name;
	double amount; 
	

	public Recipe(ResultSet rs) throws SQLException {
		recipe_name = rs.getString(Database.KEYWORD_RECIPE_NAME);
		material_name = rs.getString(Database.KEYWORD_MATERIAL_NAME);
		amount = rs.getDouble(Database.KEYWORD_AMOUNT);
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	
	public String getMaterial_name() {
		return material_name;
	}
	public double getAmount() {
		return amount;
	}
	
}
