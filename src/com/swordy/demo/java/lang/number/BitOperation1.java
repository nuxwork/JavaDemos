package com.swordy.demo.java.lang.number;

/**
 * 1. 在进行“>>>=”操作时，可能会遇到一个问题：如果对byte或short值进行这样的移位运算，
 * 得到的可能不是正确的结果。他们会先被转换成int类型，再进行右移操作，然后被截断，赋值 给原来的类型，在这种情况下可能得到-1的结果。
 * 
 * @author swordy
 * 
 */
public class BitOperation1 {
	public static void main(String[] args) {

		/*
		 * 与或非
		 */
		System.out.println("\n与或非");
		System.out.println("0 & 0 = " + (0 & 0));
		System.out.println("1 & 0 = " + (1 & 0));
		System.out.println("1 & 1 = " + (1 & 1));
		System.out.println("1 & ~0 = " + (1 & ~0));

		System.out.println();
		System.out.println("0 | 0 = " + (0 | 0));
		System.out.println("1 | 0 = " + (1 | 0));
		System.out.println("1 | 1 = " + (1 | 1));
		System.out.println("0 | ~0 = " + (0 | ~0));

		int flag = 0;
		int flag_open = 0x00000001;

		System.out.println("\nis open : " + ((flag & flag_open) == flag_open));
		System.out.println("flag |= flag_open = "
				+ Integer.toHexString(flag |= flag_open));
		System.out.println("is open : " + ((flag & flag_open) == flag_open));
		System.out.println("flag &= ~flag_open = "
				+ Integer.toHexString(flag &= ~flag_open));
		System.out.println("is open : " + ((flag & flag_open) == flag_open));

		/*
		 * 移位
		 */
		System.out.println("\n移位");
		int i = -8;
		System.out.println(Integer.toBinaryString(i));
		i >>= 10;
		System.out.println("signed >>>= " + Integer.toBinaryString(i));
		i = -8;
		System.out.println(Integer.toBinaryString(i));
		i >>>= 10;
		System.out.println("unsigned >>>= " + Integer.toBinaryString(i));

		System.out.println();
		System.out.println("3 * 8 = " + (3 * 8));
		System.out.println("3 << 3 = " + (3 << 3));
		int a = 3;
		System.out.println("a = " + a + ", do: a <<= 3; a = " + (a <<= 3));

		/*
		 * ^ 按位异或
		 */
		System.out.println("\n按位异或");
		int m = 3;
		int n = 2;
		System.out.println(Integer.toBinaryString(m) + " ^ "
				+ Integer.toBinaryString(n) + " = "
				+ Integer.toBinaryString(m ^ n));
		
		System.out.println("按位与或");
		System.out.println(Integer.toBinaryString(m) + " & "
				+ Integer.toBinaryString(n) + " = "
				+ Integer.toBinaryString(m & n));
	}

}
