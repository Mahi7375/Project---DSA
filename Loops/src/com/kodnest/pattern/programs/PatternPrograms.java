package com.kodnest.pattern.programs;

import java.util.Scanner;

public class PatternPrograms {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number of Rows = ");
		int Input = scan.nextInt();
		PatternPrograms.loop1(Input);
		scan.close();
	}
	
	// Inverse numeric loop54321
	
	public static void loop1(int num) {
		for (int col = 1; col <= num; col++) {
			for (int row = num; row >= col; row--) {
				System.out.print(row + " ");
			}
			System.out.println();
		}
	}
   
	// Star Pattern pyramid
	
	public static void loop2(int num) {
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (i + j <= num) {

					System.out.print(" ");
				} else {
					System.out.print("*");
				}				
			}
			System.out.println();
		}
	}
	
	// Numeric continues values 123456..n
	
	public static void loop3(int num) {
		for (int row = 1; row <= num; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
}
