package com.kodnest.logicalthinking;

import java.util.Scanner;

public class Binayconv {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number = ");
		BinaryNumber binary = new BinaryNumber();
		String FinalRes = binary.convertBinary(scan.nextInt());
		System.out.println("Binary Number = " + FinalRes);
		scan.close();
	}
}

class BinaryNumber {
	String convertBinary(int number) {

		String result = "";
		while (number != 0) {
			int res = number % 2;
			result = res + result;
			number /= 2;
		}
		return result;
	}
}
