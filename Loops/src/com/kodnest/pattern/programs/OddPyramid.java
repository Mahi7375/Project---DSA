package com.kodnest.pattern.programs;

import java.util.Scanner;

public class OddPyramid {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a Number = ");
		Logic logic = new Logic();
		logic.inversePattern3(scanner.nextInt());
		scanner.close();
	}

}


class Logic {
	void oddPattern(int Input) {
		for (int i = 1; i <= Input; i++) {
			for (int space = i; space <= Input - 1; space++) {
				System.out.print(" ");
			}
			for (int star = 1; star <= i * 2 - 1; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	void inversePattern2(int Input) {
		for (int i = Input; i >= 1; i--) {
			for (int space = i; space <= Input - 1; space++) {
				System.out.print(" ");
			}
			for (int star = 1; star <= i * 2 - 1; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	void inversePattern3(int Input) {
		for (int rows = Input; rows >= 1; rows--) {
			for (int space = 1; space <= Input - rows; space++) {
				System.out.print(" ");
			}
			for (int stars = 1; stars <=  2 * rows - 1; stars++) {
				System.out.print("*");				
			}
			System.out.println();
		}
	}
}
