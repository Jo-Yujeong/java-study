package com.test06.biz;

import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineBiz implements IVendingMachineBiz{
	private int balance; //���� �ܾ�
	private Drink[] cartList; //���Ը�� �迭
	private int count; //�迭 ����
	
	
	
	public VendingMachineBiz() {
		this.balance = 1000;
		this.cartList = new Drink[3];
		this.count = 0;
	}

	@Override
	public void cartDrink(Drink drink) { //����� ���� ���� ����
		String menu = "";
		
		if(drink instanceof Coffee)
			menu = "Ŀ��";
		else if(drink instanceof Juice)
			menu = "�ֽ�";
		else if(drink instanceof Coke)
			menu = "�ݶ�";
		
		int afterBalance = balance - drink.getPrice();
		
		if(afterBalance < 0) {
			System.out.println("�ܾ��� �����Ͽ� " + menu + "�� ������ �� �����ϴ�.");
			return; //�ܾ��� ������ ���, cartList[count]���� �������� �ʰ� �޼��� Ż��
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
		System.out.println(menu + "�� �����߽��ϴ�. ���� �ܾ� : " + balance + " ��");
	}
	
	@Override
	public void printCart() { //���� ��� �迭�� ����� ������ ���
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
			System.out.println("Ŀ�� : " + coffee + " ��");
		if(juice != 0)
			System.out.println("�ֽ� : " + juice + " ��");
		if(coke != 0)
			System.out.println("�ݶ� : " + coke + " ��");
		System.out.println("��� �ݾ� : " + (cDrink.getPrice()*coffee+jDrink.getPrice()*juice+coDrink.getPrice()*coke) + " ��");
		System.out.println("���� �ݾ� : " + balance + " ��");
	}
	
	@Override
	public void printDrinkList(Drink[] drinkList) { //���Ǳ� ���� ��� ����� ���
		for(Drink d : drinkList) {
			System.out.println(d.toString());
		}
		System.out.println("���� �ݾ� : " + balance + " ��");
	}
}
