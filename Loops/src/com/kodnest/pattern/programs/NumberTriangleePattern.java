package com.kodnest.pattern.programs;

import java.util.Scanner;

public class NumberTriangleePattern {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number = ");
		int InputNumber = scan.nextInt();
		Pattern1 pattern1 = new Pattern1();
		pattern1.method1(InputNumber);
		pattern2(InputNumber);
		scan.close();
	}

	public static void pattern2(int n) {
		for (int rows = 1; rows <= n; rows++) {
			for (int col = 1; col <= n - rows; col++) {
				System.out.print(" ");
			}
			for (int col2 = 1; col2 <= rows; col2++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	

}

class Pattern1 {
	void method1(int num) {
		int result = 0;
		for (int row = 1; row <= num; row++) {
			for (int col = 1; col <= num - row; col++) {
				System.out.print(" ");
			}
			for (int col = 1; col <= row; col++) {
				result++;
				System.out.print(result + " ");
			}
			System.out.println();
		}
	}
}
