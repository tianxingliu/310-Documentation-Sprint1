package info;

import java.util.ArrayList;

public class GroceryInfo extends Info {
	
	public ArrayList<String> items;
	
	public GroceryInfo(ArrayList<String> ingredients) {
		this.items = ingredients;
	}
	
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		return false;
	}

}
