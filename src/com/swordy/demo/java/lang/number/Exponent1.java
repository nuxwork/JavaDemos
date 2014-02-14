package com.swordy.demo.java.lang.number;

/**
 * 1. 指数计数默认为double类型，通过在末尾加“f”转换
 * 2. 在科学工程中 e = Math.E = 2.718。 1.39e-43f表示 1.39 乘以 e 的 -43 次方
 * 3. 但是在Fortran中e表示10，并且这个习惯被保留了下来，C/C++/Java中e都表示10
 * 
 * @author swordy
 * 
 */
public class Exponent1 {
	public static void main(String[] args) {

		/*
		 * 指数计数默认为double类型，通过在末尾加“f”转换
		 */
		System.out.println("1.39e-12 = " + 1.39e-12);
		System.out.println("1.39e-12f = " + 1.39e-12f);
		
		/*
		 * 在科学工程中 e = Math.E = 2.718。 1.39e-43f表示 1.39 乘以 e 的 -43 次方
		 */
		System.out.println("Math.E = " + Math.E);

		/*
		 * 但是在Fortran中e表示10，并且这个习惯被保留了下来，C/C++/Java中e都表示10
		 */
		System.out.println("1e+1 = " + 1e+1);
		System.out.println("1e-1 = " + 1e-1);
	}
}
