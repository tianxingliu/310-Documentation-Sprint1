package info;

import java.util.ArrayList;

public class QuickAccess extends Info {
	public String item;
	
	public QuickAccess(String searchResults) {
		this.item = searchResults;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == this) return true;
		if(!(other instanceof QuickAccess)) return false;
		QuickAccess otherGroceryInfo = (QuickAccess) other;
		return this.item.equals(otherGroceryInfo.item);
	}

}
