package com.swordy.demo.java.thread;

/**
 * 1. 在Java程序中，只要有一个前台线程在运行，整个Java进程都不会消失。 
 * 2. setDeamon(true)方法可是将线程设置为后台线程，并且必须是在线程启动前才能设置。 
 * 3. 后台线程在Java进程退出后仍然会执行。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class Deamon1
{
	private static final String TAG = "JavaDemos.Thread4";

	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Mouse(), "white-mouse");

		if (!t1.isAlive())
		{
			t1.setDaemon(true);
		}
		t1.start();

		int i = 0;
		while (i++ != 10)
		{
			Thread.yield();
			System.out.println(Thread.currentThread().getName() + " run " + i);
		}
		System.out.println("main exit.");
	}

	private static class Mouse implements Runnable
	{

		@Override
		public void run()
		{
			int i = 0;
			while (true)
			{
				/*
				 * 让当前线程暂停，把执行机会让给其他线程。
				 */
				Thread.yield();
				System.out.println(Thread.currentThread().getName() + " run " + i++);
			}
		}
	}
}
