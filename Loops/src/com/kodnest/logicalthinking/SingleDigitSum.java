package com.kodnest.logicalthinking;

import java.util.Scanner;

public class SingleDigitSum {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();

	        int result = singleDigitSum(number);
	        System.out.println("Single digit sum: " + result);
	        scanner.close();
	    }
	
	
	

    // Function to calculate single digit sum
    public static int singleDigitSum(int num) {
        while (num >= 10) {
            num = sumOfDigits(num);
        }
        return num;
    }

    // Helper function to sum the digits of a number
    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10; // Add last digit
            num /= 10;       // Remove last digit
        }
        return sum;
    }

   
}

