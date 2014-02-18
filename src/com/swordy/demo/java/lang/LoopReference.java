package com.swordy.demo.java.lang;

/**
 * 1. 当出现循环引用时，尽管两个对象的引用都被显示的置为null
 * 但是对象互相还持有引用，他们的引用计数就永远不会为0，即永远
 * 不会被释放。JVM采用了另一种方式：对于任何“活”的对象，一定能
 * 最终追朔到其存活在堆栈或静态存储区之中的引用。由此，如果从堆
 * 栈和静态存储区开始，遍历所有的引用，就能找到所有引用，如此反
 * 复进行，直到“根源于堆栈和静态存储区的引用”所形成的网络全部被
 * 访问为止。
 * 
 * @author swordy
 *
 */
public class LoopReference {
	public static void main(String[] args) throws InterruptedException {
		Cat cat = new Cat();
		Mouse mouse = new Mouse();
		cat.setMouse(mouse);
		mouse.setCat(cat);
		
		cat = null;
		mouse = null;
		
		Thread.sleep(10);
		System.gc();
		Thread.sleep(10);
	}
	
	private static class Cat
	{
		Mouse mouse;
		public void setMouse(Mouse mouse)
		{
			this.mouse = mouse;
		}
		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			System.out.println("Cat finalize.");
		}
		
		
	}
	
	private static class Mouse
	{
		Cat cat ;
		public void setCat(Cat cat)
		{
			this.cat = cat;
		}
		@Override
		protected void finalize() throws Throwable {
			super.finalize();
			System.out.println("Mouse finalize.");
		}
		
	}
}
