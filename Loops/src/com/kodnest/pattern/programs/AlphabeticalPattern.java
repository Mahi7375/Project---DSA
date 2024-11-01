package com.kodnest.pattern.programs;

public class AlphabeticalPattern {

	public static void main(String[] args) {
		Pattern1();
	}

	public static void Pattern1() {
		int N = 4;		
		for (int i = 0; i < N; i++) {
			int Alpha = 65;		
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (Alpha + i) + " ");
			}
			System.out.println();
		}		
		for (int i = 3; i >= 1; i--) {
			int Alpha2 = 64;
			for (int j = 0; j < i; j++) {
				System.out.print((char) (Alpha2+ i) + " ");
			}
			System.out.println();
		}

	}

	public static void Pattern2() {
		for (char a = 65; a <= 69; a++) {
			// For type casting char b = (char) a;
			System.out.print(a + " ");
		}
	}

}
