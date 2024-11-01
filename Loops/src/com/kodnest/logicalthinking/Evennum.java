package com.kodnest.logicalthinking;

import java.util.Scanner;

public class Evennum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number = ");
		CheckEvenNumbers method = new CheckEvenNumbers();		
		method.checkevennumbers(scan.nextInt());
		scan.close();

	}
	
	

}
