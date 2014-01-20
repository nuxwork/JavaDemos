package com.swordy.demo.java.thread;

/**
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class MultiThread2 {
	private static final String TAG = "JavaDemos.MultiThread2";
	
	public static void main(String[] args) 
	{
		Thread t1 = new Thread(new Runnable1(), "thr-1");
		
		/*
		 * 设置线程为后台线程，
		 * true: 当主线程退出时，后台线程也会退出。
		 * false: 当主线程退出时，后台线程仍会执行
		 * default = false;
		 */
		t1.setDaemon(true);
		t1.start();
		
		int index = 0;
		while(true)
		{
			if(index++==10000)
			{
				break;
			}
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("main exit.");
	}
	
	private static class Runnable1 implements Runnable
	{

		@Override
		public void run() {
			while(true)
			{
				System.out.println(Thread.currentThread().getName());
				/*
				 * 让当前线程暂停，把执行机会让给其他线程。
				 */
				Thread.yield();
			}
		}
		
	}
}
