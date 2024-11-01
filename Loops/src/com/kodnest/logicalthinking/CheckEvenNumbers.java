package com.kodnest.logicalthinking;

public class CheckEvenNumbers {
 void checkevennumbers(int num) {
	 System.out.println("The first " + num + " even numbers are = ");
	 	 for (int i = 1; i <= num *2; i++) {
		 
		 if (i % 2 == 0) {			
			 System.out.println (i);
		 }		 
	 }
 }
}
