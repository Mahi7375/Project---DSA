package com.kodnest.logicalthinking;
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Number to check = ");
		int number = scan.nextInt();
		boolean result = Palindrome.palindrome(number);
		if (result == true) {
			System.out.println("The Number is Palindrome one");
		}else {
			System.out.println("Not a Palindrome");
		}
		scan.close();
		
	}
	
	public static boolean palindrome(int num) {
		int original = num;
		int reverse = 0;
		while (num !=0) {
			int digit = num % 10;
			reverse = reverse * 10 + digit;
			num /= 10;
		}
		
		if (original == reverse) {
			return true;
		} else {
			return false;
		}
	}
}
		
		
