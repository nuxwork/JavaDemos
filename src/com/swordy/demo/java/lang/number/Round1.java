package com.swordy.demo.java.lang.number;

/**
 * 
 * @author swordy
 *
 */
public class Round1 {
	public static void main(String[] args) {
		float f1 = 92.2f;
		float f2 = 92.7f;
		System.out.println(f1 + " to int = " + (int) f1);
		System.out.println(f2 + " to int = " + (int) f2);

		System.out.println();
		System.out.println(f1 + " round = " + Math.round(f1));
		System.out.println(f2 + " round = " + Math.round(f2));

		float f3 = -7.5f;
		float f4 = 7.5f;
		System.out.println();
		System.out.println(f3 + " round = " + Math.round(f3));
		System.out.println(f4 + " round = " + Math.round(f4));
	}
}
