package com.swordy.demo.java.lang;

public class Switch1 {
	enum Color {
		RED, GREEN, BLUE
	}

	public static void main(String[] args) {
		System.out.println("int switch:");
		intSwitch(0);
		System.out.println();
		intSwitch(1);

		System.out.println("\nchar switch: ");
		charSwitch('c');
		
		
		System.out.println("\nenum switch: ");
		enumSwitch(Color.BLUE);
	}

	private static void intSwitch(int a) {
		switch (a) {
		case 0:
			System.out.println("case 0");
			break;
		case 1:
			System.out.println("case 1");
			// break;
			System.out.println("没有break会继续执行，直到遇到break");
		case 2:
			System.out.println("case 2");
			break;

		default:
			break;
		}
	}

	private static void charSwitch(char a) {
		switch (a) {
		case 'a':
			System.out.println("case a");
			break;
		case 'b':
			System.out.println("case b");
			// break;
			System.out.println("没有break会继续执行，直到遇到break");
		case 'c':
			System.out.println("case c");
			break;

		default:
			break;
		}
	}

	private static void enumSwitch(Color c) {
		switch (c) {
		case RED:
			System.out.println("case RED");
			break;
		case GREEN:
			System.out.println("case GREEN");
			// break;
			System.out.println("没有break会继续执行，直到遇到break");
		case BLUE:
			System.out.println("case BLUE");
			break;

		default:
			break;
		}
	}
}
