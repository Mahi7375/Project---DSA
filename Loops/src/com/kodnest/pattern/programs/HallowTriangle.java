package com.kodnest.pattern.programs;

public class HallowTriangle {

	public static void main(String[] args) {
		int N = 5;
		for (int i = 1; i <= N; i++) {
			// for spaces
			for (int j = 1; j <= N-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i ; k++) {
				if (k == i || i == N || k == 1) {
					System.out.print("* ");
					
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
