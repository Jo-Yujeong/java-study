package com.test06.entity;

public class Coke extends Drink {
	public static final int COKE_PRICE = 50;

	public Coke() {
		super(COKE_PRICE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ÄÝ¶ó\t" + COKE_PRICE;
	}
}
