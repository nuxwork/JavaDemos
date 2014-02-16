package com.swordy.demo.java.lang;

/**
 * 1. Java有垃圾回收器负责回收无用对象占据的内存资源
 * 2. 对于（并非使用new）获得了一块“特殊”的内存区域（如在native中申请的），
 * 由于垃圾回收器只知道释放那些经由new分配的内存，所以它不知道改如何释放该对象
 * 的这块“特殊”内存。为了应对这种情况，Java允许在类中定义一个名为finalize()的
 * 方法。它的工作原理是一旦垃圾回收器准备好释放对象占用的存储空间，将首先调用其
 * finalize()方法，并且在下一次垃圾回收动作发生时才会真正回收对象占用的内存。
 * 参考android.graphics.Bitmap
 * 3. 不建议直接调用finalize();方法，这会导致finalize()执行多次，不便于维护，
 * 如果非要这么做，可以定义自己的释放资源的方法（如release(方法)）。
 * 
 * @author swordy
 *
 */
public class Recycle1 {
	public static void main(String[] args) throws Throwable {

		System.out.println("sdf");
		Image img = new Image("d:/image/img1.jpg");
		img.finalize();
		img = null;
		
		System.gc();
		Thread.sleep(1);
		

	}

	public static class Image {
		public String path;

		public Image(String path) {
			this.path = path;
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println("before:  " + path);
			super.finalize();
			System.out.println("after: " + path);
		}
	}
}
