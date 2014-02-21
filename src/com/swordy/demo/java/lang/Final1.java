package com.swordy.demo.java.lang;

/*
 * 1. 空白final必须在构造函数里初始化
 * 2. Java中的final方法同C++中的内联函数一样，直接将方法体的代码在执行处展开，以减少函数调用开销。
 * 3. 类中所有private方法都隐式的指定为是final的。
 * 4. final 类中的所有方法，都隐式的指定为final的，因为无法覆盖他们。
 * 5. 一般，类的代码只有在第一次使用时，即创建第一个对象时才会加载，当然，访问static域时也会发生加载。
 */
public class Final1 {
	private final String a;

	public Final1() {
		init();
		a = "hello blank final";
	}

	public static void main(String[] args) {
		Final1 f = new Final1();
		String result = f.finalMethod("final method.");
		System.out.println(result);
	}

	private void init() {
		// ! a = "hello blank final";
	}

	public final String finalMethod(String str) {
		String result = "hello" + str;
		return result;
	}
}
