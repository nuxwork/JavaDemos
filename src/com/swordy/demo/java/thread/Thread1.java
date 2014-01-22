package com.swordy.demo.java.thread;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 1. 线程可以通过继承Thread实现，也可以通过实现Runnable接口实现
 * 2. 创建线程时最后给线程命名，方便定位问题。
 * 3. 多个线程运行时，会交替运行，运行的机会取决于优先级。
 * 4. yield()方法只是暂停当前线程的执行，不影响下次执行机会的竞争。
 * 5. 线程中为捕获的异常可以通过实现UncaughtExceptionHandler接口来捕获。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class Thread1
{
	private static final String TAG = "JavaDemos.Thread1";

	public static void main(String[] args)
	{
		/*
		 * 线程可以通过继承Thread来实现 实例化线程时最好设置线程的名字
		 */
		Thread thr1 = new MyThread("mythread ~~~~~~~~~~~~~ ");
		/*
		 * 通过实现Runnable接口来实现线程
		 */
		/*
		 * 设置线程的优先级,默认为Thread.NORM_PRIORITY=5
		 */
		thr1.setPriority(10);
		
		
		Thread thr2 = new Thread(new MyRunnable());
		/*
		 * 设置线程的名字
		 */
		thr2.setName("runner *************** ");

		thr2.setUncaughtExceptionHandler(new CrashHandler());

		/*
		 * 线程的启动使用Thread.start()方法
		 */
		thr1.start();
		/*
		 * thr1与thr2交替执行
		 */
		thr2.start();
	}

	private static class CrashHandler implements UncaughtExceptionHandler
	{

		@Override
		public void uncaughtException(Thread arg0, Throwable arg1)
		{
			System.out.println("捕获到未处理的异常 > ThreadName: " + arg0.getName() + ", Throwable: "
					+ arg1.toString());
		}

	}

	private static class MyThread extends Thread
	{
		public MyThread()
		{
			super();
		}

		public MyThread(String name)
		{
			super(name);
		}

		int i = 0;
		
		@Override
		public void run()
		{
			while (i++ < 10)
			{
				System.out.println(Thread.currentThread().getName());
				
				/*
				 * 放弃本次的运行机会，不影响下次的竞争。
				 */
				Thread.yield();
			}
		}
	}

	private static class MyRunnable implements Runnable
	{

		int i = 0;
		
		@Override
		public void run()
		{
			while (i++ < 10)
			{
				System.out.println(Thread.currentThread().getName());
				if(i == 8)
				{
					Object obj = null;
					obj.toString();
					break;
				}
				Thread.yield();
			}
		}

	}
}
