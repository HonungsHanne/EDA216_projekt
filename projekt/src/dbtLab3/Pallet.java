package dbtLab3;

import java.sql.Date;

public class Pallet {
	int pallet_nbr, pallet_order_id;
	Date timestamp;
	boolean blocked;
	String recipe_name;
	
	public Pallet(){
	}
	
	public int getPallet_nbr() {
		return pallet_nbr;
	}

	public void setPallet_nbr(int pallet_nbr) {
		this.pallet_nbr = pallet_nbr;
	}

	public int getPallet_order_id() {
		return pallet_order_id;
	}

	public void setPallet_order_id(int pallet_order_id) {
		this.pallet_order_id = pallet_order_id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}	
}
