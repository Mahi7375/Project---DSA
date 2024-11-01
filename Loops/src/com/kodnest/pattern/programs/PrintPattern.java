package com.kodnest.pattern.programs;

import java.util.Scanner;

public class PrintPattern {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Rows = ");
		PrintPatternclass.printRightAngledTriangleCharacterPattern(scan.nextInt());
		System.out.println("===============================");
		System.out.println("Ended the Program");
		scan.close();

	}
}
