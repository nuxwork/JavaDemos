package com.swordy.demo.java.thread;

public class MultiThread1 {
	private static final String TAG = "JavaDemos.MultiThread1";

	public static void main(String[] args) 
	{
		/* 
		 * 线程可以通过继承Thread来实现
		 */
		Thread thr1 = new Thread1("thread1");
		/*
		 * 通过实现Runnable接口来实现线程
		 */
		Thread thr2 = new Thread(new Runnable1());
		
		/*
		 * 线程的启动使用Thread.start()方法
		 */
		thr1.start();
		thr2.start();
		/*
		 * 各线程交替执行
		 */
	}
	
	private static class Thread1 extends Thread
	{
		public Thread1()
		{
			super();
		}
		
		public Thread1(String name)
		{
			super(name);
		}
		
		@Override
		public void run() {
			while(true)
			{
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	private static class Runnable1 implements Runnable
	{

		@Override
		public void run() {
			while(true)
			{
				System.out.println(Thread.currentThread().getName());
			}
		}
		
	}
}
