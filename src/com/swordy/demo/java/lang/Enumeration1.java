package com.swordy.demo.java.lang;

import java.util.Arrays;

/**
 * Enumeration示例
 * 
 * @author swordy
 * 
 */
public class Enumeration1 {
	public static void main(String[] args) {
		Color c = Color.RED;

		System.out.println(Arrays.toString(Color.values()));
		System.out.println("c  -->   " + c);
		System.out.println("c.ordinal()  -->   " + c.ordinal());
		System.out.println("c.compareTo(Color.BLUE)  -->   " + c.compareTo(Color.BLUE));
		System.out.println("c.equals(Color.GREEN)  -->   " + c.equals(Color.GREEN));
		System.out.println("c == Color.RED  -->   " + (c == Color.RED));
		System.out.println("c.name()  -->   " + c.name());
	}

	enum Color {
		RED, GREEN, BLUE
	}
}
