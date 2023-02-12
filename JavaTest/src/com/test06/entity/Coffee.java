package com.test06.entity;

public class Coffee extends Drink {
	public static final int COFFEE_PRICE = 100;

	public Coffee() {
		super(COFFEE_PRICE);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Ä¿ÇÇ\t" + COFFEE_PRICE;
	}
}
