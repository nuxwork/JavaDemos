package com.swordy.demo.java.lang.extend;

/*
 * 1. 如果子类的构造函数中没有调用父类的构造函数，则java默认调用父类的无参构造函数。
 * 2. 如果父类没有无参构造函数，那么子类的构造函数中必须调用父类的构造函数
 * 3. 父类中没有可见的构造函数时，该父类将不能被继承
 */
public class Main {
	public static void main(String[] args) {
		Mouse m = new Mouse("jiji");
		m.cry();
		m.callSuper();
		
		System.out.println();
		Mouse m1 = new Mouse(1);
	}
	
	private class A{
		private A(int a)
		{
			
		}
	}

	// 当父类中没有默认的构造函数时，也没有可见的构造函数，那么将无法被继承
//	private class B extends A
//	{
//	}
}
