package com.test06.entity;

public class Juice extends Drink {
	public static final int JUICE_PRICE = 200;

	public Juice() {
		super(JUICE_PRICE);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "¡÷Ω∫\t" + JUICE_PRICE;
	}
}
