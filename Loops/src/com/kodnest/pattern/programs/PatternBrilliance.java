package com.kodnest.pattern.programs;

public class PatternBrilliance {

	public static void main(String[] args) {
			int Input = 5;
			for (int rows = Input; rows >= 1; rows--) {
				for (int space = 1; space <= Input - rows; space++) {
					System.out.print(" ");
				}
				for (int stars = 1; stars <=  2 * rows - 1; stars++) {
					System.out.print("*");				
				}
				System.out.println();
			}
			for (int rows = 2; rows <= Input; rows++) {
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
