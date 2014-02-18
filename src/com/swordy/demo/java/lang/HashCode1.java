package com.swordy.demo.java.lang;

/**
 * 1. hasCode跟物理地址没有任何关系
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class HashCode1 {
	private static final String TAG = "JavaDemos.HashCode1";

	public static void main(String[] args) {
		System.out.println("Objetc的hashCode都不一样");
		System.out.println("obj1 hashCode = " + new Object().hashCode());
		System.out.println("obj2 hashCode = " + new Object().hashCode());

		System.out.println("其他数据类得hashCode跟内容有关");
		System.out.println("1 hashCode = " + new Integer(1).hashCode());
		System.out.println("-1 hashCode = " + new Integer(-1).hashCode());
		System.out.println("1.01 hashCode = " + new Float(1.01).hashCode());
		System.out.println("hello hashCode = " + "hello".hashCode());
		System.out.println("hello hashCode = " + "hello".hashCode());
		
		System.out.println("验证hasCode跟物理地址没有任何关系");
		verify();
	}

	private static void verify() {
		Mouse[] ints = new Mouse[10];
		int len = ints.length;
		for (int i = 0; i != len; i++) {
			ints[i] = new Mouse();
			ints[i].id = i;
			System.out.println(ints[i]);
		}
	}
	
	static class Mouse
	{
		public int id;
	}
}
