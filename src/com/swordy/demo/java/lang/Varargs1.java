package com.swordy.demo.java.lang;

import java.util.Arrays;

/**
 * 1. 可变参数列表实际上是一个数组
 * 2. 可变参数只能放在参数列表的最后
 * 3. 可变参数只能有一个
 * 
 * @author swordy
 * 
 */
public class Varargs1 {
	public static void main(String[] args) {
		vars1(1, 2, 3, 4, 45);
		vars2("Apple","Google","Microsoft");
	}

	static void vars1(int... args) {
		System.out.println(Arrays.toString(args));
	}
	
	static void vars2(String...args)
	{
		System.out.println(Arrays.toString(args));
	}
}
