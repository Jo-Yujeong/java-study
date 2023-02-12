package com.test06;

import java.util.Scanner;

import com.test06.biz.VendingMachineBiz;
import com.test06.entity.Coffee;
import com.test06.entity.Coke;
import com.test06.entity.Drink;
import com.test06.entity.Juice;

public class VendingMachineTest {
	
	private static void printMenu() {
		System.out.println("============================\n" +
						   "[음료수 자판기 관리 시스템]\n" +
						   "============================\n" +
						   "1. 전체 음료수 및 잔액 보기\n" +
						   "2. 주스 구입하기 (200원)\n" +
						   "3. 커피 구입하기 (100원)\n" +
						   "4. 콜라 구입하기 (50원)\n" +
						   "5. 구입한 음료수 목록 보기\n" +
						   "9. 종료");
		System.out.print("메뉴 입력 => ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VendingMachineBiz machine = new VendingMachineBiz();
		Drink[] drinkList = {new Juice(), new Coffee(), new Coke()};
		boolean flag = true;
		
		while(flag) {
			printMenu();
			int num = sc.nextInt();
			switch(num) {
			case 1:
				machine.printDrinkList(drinkList);
				break;
			case 2: //주스
				machine.cartDrink(drinkList[0]);
				break;
			case 3: //커피
				machine.cartDrink(drinkList[1]);
				break;
			case 4: //콜라
				machine.cartDrink(drinkList[2]);
				break;
			case 5:
				machine.printCart();
				break;
			case 9:
				System.out.println("프로그램 종료");
				flag = false;
				break ;
			default:
					System.out.println("메뉴값을 확인 후 다시 입력하세요."); // 보기 외 번호 입력.
			}
		}
	}

}
