package com.kodnest.pattern.programs;

public class PrintPatternclass {

	public static void printRightAngledTriangleCharacterPattern(int numberofRows) {
		System.out.println("===============================");
		for (int i = 1; i <= numberofRows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("A ");
			}
			System.out.println();
		}

	}
}
