package com.kodnest.pattern.programs;

public class HallowSquare {

	public static void main(String[] args) {
		HallowSquare.hallowRectangle();

	}
	static void hallowRectangle() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j < 5; j++) {
				if (i == 1 || i == 4 ||j == 1 || j == 4)
				System.out.print("* ");
				else {
					System.out.print("  ");
				}
						
			}
			System.out.println();
		}
	}

}
