package com.test06.biz;

import com.test06.entity.Drink;

public interface IVendingMachineBiz {
	public abstract void cartDrink(Drink drink);
	public abstract void printCart();
	public abstract void printDrinkList(Drink[] drinkList);
}
