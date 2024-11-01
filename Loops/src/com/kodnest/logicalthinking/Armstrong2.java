package com.kodnest.logicalthinking;

import java.util.Scanner;

public class Armstrong2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        
        System.out.println(checkArmstrong(number));
        scan.close();
    }

    public static boolean checkArmstrong(int num) {
        int originalNumber = num;
        int digitCount = 0, finalNumber = 0;

        // Calculate the number of digits in the number
        int temp = num;
        while (temp != 0) {
            digitCount++;
            temp = temp / 10;
        }

        // Calculate the Armstrong number sum
        temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            int power = 1;
            
            // Calculate the digit raised to the power of digitCount
            for (int i = 0; i < digitCount; i++) {
                power *= digit;
            }
            
            finalNumber += power;
            temp = temp / 10;
        }

        // Check if the calculated sum is equal to the original number
        return finalNumber == originalNumber;
    }
}

