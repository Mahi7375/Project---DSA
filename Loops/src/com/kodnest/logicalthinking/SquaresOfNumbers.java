package com.kodnest.logicalthinking;

public class SquaresOfNumbers {

	public static void main(String[] args) {
		int number = 20;		
		Classloops program3 = new Classloops();
		program3.squareofnumbers(number);
		
	}
}
	// for using non static methods you have to create two classes means
   // class should be end( it means creating an object from the class)
	 class Classloops {

		public void squareofnumbers(int num) {
			int result = 0;
			for (int i = 1; i <= num; i++) {
				result = result + i * i;
			}
			System.out.println("Sum of squares of " + result);
		}

	}

	

