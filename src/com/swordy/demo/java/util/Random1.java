package com.swordy.demo.java.util;

import java.util.Arrays;
import java.util.Random;

/**
 * 1. 随机数种子一样，则生成的随机数也一样。因此，通常使用当前时间做随机数种子.
 * 
 * @author swordy
 * 
 */
public class Random1 {

	public static void main(String[] args) {

		// Random(随机数种子)
		// 通常用当前时间做随机数种子
		Random r = new Random(System.currentTimeMillis());
		System.out.println(r.nextBoolean());
		System.out.println(r.nextDouble());
		System.out.println(r.nextFloat());
		System.out.println(r.nextGaussian());
		System.out.println(r.nextInt());

		// 0 到 100 之间的随机整数
		System.out.println(r.nextInt(100));
		System.out.println(r.nextLong());

		byte[] bytes = new byte[10];
		r.nextBytes(bytes);
		System.out.println(Arrays.toString(bytes));

		// 随机数种子一样，那么生成的随机数也一样

		System.out.println(new Random(100).nextInt());
		System.out.println(new Random(100).nextInt());
	}
}
