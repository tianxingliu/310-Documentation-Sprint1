package info;

import java.util.ArrayList;

public class History {
	 public String query;
	 public int key;
	 public int number;
	 public int radius;
	 
		public History( String querry,int number,int radius) {
			this.query = query;
			this.number = number;
			this.radius = radius;
		}
		
	public History(int key, String querry,int number,int radius) {
		this.key = key;
		this.query = query;
		this.number = number;
		this.radius = radius;
	}
}
