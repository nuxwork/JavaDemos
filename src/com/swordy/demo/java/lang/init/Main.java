package com.swordy.demo.java.lang.init;

/**
 * 1. 初始化的顺序是：先静态对象（如果用到），自上而下；而后是“非静态”对象，自上而下。
 * 2. 静态成员只有在第一次使用时才会初始化，此后不再初始化。
 * 3. 即使没有显示的使用static关键字，构造器实际上也是静态方法。
 * 
 * @author swordy
 *
 */
public class Main {
	public static void main(String[] args) {
		Mouse m1 = new Mouse("hali");
		Cat c1 = new Cat("mimi");
		
	}
}
