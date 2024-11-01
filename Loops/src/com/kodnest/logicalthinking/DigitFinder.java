package com.kodnest.logicalthinking;

public class DigitFinder {

	public static void main(String[] args) {
		 long n = 68686876876868l;
		 System.out.println(DigitFinder.digit(n));

	}
	public static long digit(long num) {
		int count = 0;				
		while (num > 0) {
			count ++;
		    num = num / 10;				 
		}
		return count;
	}
}
