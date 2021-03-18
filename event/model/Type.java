package event.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Type {
	
	private int id;
	private String type;
	private double price;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
