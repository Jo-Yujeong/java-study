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
						   "[����� ���Ǳ� ���� �ý���]\n" +
						   "============================\n" +
						   "1. ��ü ����� �� �ܾ� ����\n" +
						   "2. �ֽ� �����ϱ� (200��)\n" +
						   "3. Ŀ�� �����ϱ� (100��)\n" +
						   "4. �ݶ� �����ϱ� (50��)\n" +
						   "5. ������ ����� ��� ����\n" +
						   "9. ����");
		System.out.print("�޴� �Է� => ");
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
			case 2: //�ֽ�
				machine.cartDrink(drinkList[0]);
				break;
			case 3: //Ŀ��
				machine.cartDrink(drinkList[1]);
				break;
			case 4: //�ݶ�
				machine.cartDrink(drinkList[2]);
				break;
			case 5:
				machine.printCart();
				break;
			case 9:
				System.out.println("���α׷� ����");
				flag = false;
				break ;
			default:
					System.out.println("�޴����� Ȯ�� �� �ٽ� �Է��ϼ���."); // ���� �� ��ȣ �Է�.
			}
		}
	}

}
