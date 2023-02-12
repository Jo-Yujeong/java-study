package com.test06.biz;

import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineBiz implements IVendingMachineBiz{
	private int balance; //현재 잔액
	private Drink[] cartList; //구입목록 배열
	private int count; //배열 개수
	
	
	
	public VendingMachineBiz() {
		this.balance = 1000;
		this.cartList = new Drink[3];
		this.count = 0;
	}

	@Override
	public void cartDrink(Drink drink) { //음료수 구매 로직 구현
		String menu = "";
		
		if(drink instanceof Coffee)
			menu = "커피";
		else if(drink instanceof Juice)
			menu = "주스";
		else if(drink instanceof Coke)
			menu = "콜라";
		
		int afterBalance = balance - drink.getPrice();
		
		if(afterBalance < 0) {
			System.out.println("잔액이 부족하여 " + menu + "를 구입할 수 없습니다.");
			return; //잔액이 부족할 경우, cartList[count]부터 실행하지 않고 메서드 탈출
		}
		
		cartList[count] = drink;
		count++;
		
		if(count == cartList.length) {
			Drink[] newCart = new Drink[cartList.length*3];
			
			for(int i=0; i<cartList.length; i++) {
				newCart[i] = cartList[i];
			}
			cartList = newCart;
		}
		
		balance = afterBalance;
		System.out.println(menu + "를 구매했습니다. 현재 잔액 : " + balance + " 원");
	}
	
	@Override
	public void printCart() { //구매 목록 배열에 저장된 정보를 출력
		Drink cDrink = new Coffee();
		Drink jDrink = new Juice();
		Drink coDrink = new Coke();
		int coffee = 0;
		int juice = 0;
		int coke = 0;
		
		for(Drink d : cartList) {
			if(d instanceof Coffee)
				coffee++;
			else if(d instanceof Juice)
				juice++;
			else if(d instanceof Coke)
				coke++;
		}
		if(coffee != 0)
			System.out.println("커피 : " + coffee + " 개");
		if(juice != 0)
			System.out.println("주스 : " + juice + " 개");
		if(coke != 0)
			System.out.println("콜라 : " + coke + " 개");
		System.out.println("사용 금액 : " + (cDrink.getPrice()*coffee+jDrink.getPrice()*juice+coDrink.getPrice()*coke) + " 원");
		System.out.println("남은 금액 : " + balance + " 원");
	}
	
	@Override
	public void printDrinkList(Drink[] drinkList) { //자판기 내의 모든 음료수 출력
		for(Drink d : drinkList) {
			System.out.println(d.toString());
		}
		System.out.println("현재 금액 : " + balance + " 원");
	}
}
