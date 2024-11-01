package com.kodnest.logicalthinking;
import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		Armstrongclass Armstrongnum = new Armstrongclass();
		
		System.out.println(Armstrongnum.checkArmstrong(number));
		scan.close();

	}
}

class Armstrongclass {

	
	public boolean checkArmstrong(int num) {
		int OriginalNumber = num;
		int digitCount = Armstrongclass.getDigitCount(num);
		int finalNumber = 0;
		
		while (num != 0) {
			int digi = num % 10;
			int powres = Armstrongclass.getPower(digi,digitCount);
			finalNumber = finalNumber + powres;
			num = num/10;
		}		

		if (finalNumber == OriginalNumber) {
			return true;
		} else {
			return false;
		}
	}

	 static int getDigitCount(int num) {
		int count = 0;
		while (num != 0) {			
			count++;
			num= num / 10;
			
		}
		return count;	 
	}

	 static int getPower(int digit, int raisePower) {
		 int res = 1;
		 for (int i = 1; i <= raisePower;i++) {
			 res = res *digit;
		 }
		 return res;
	}
}




