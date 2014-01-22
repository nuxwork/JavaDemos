package com.swordy.demo.java.thread;

/**
 * 1. 中断线程的执行使用interruput()方法
 * 2. 如果中断处于睡眠sleep或等待waite状态的线程，则会出发InterruptedException
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Thread3
{
	private static final String TAG = "JavaDemos.Thread3";

	public static void main(String[] args)
	{
		Mouse mouse = new Mouse("white-mouse");
		mouse.start();
		
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("interruput " + mouse.getName() + " running.");
		mouse.interrupt();
	}

	private static class Mouse extends Thread
	{
		public Mouse(String name)
		{
			super(name);
		}

		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getName() + " running...");
			try
			{
				System.out.println(Thread.currentThread().getName() + " sleep 5s.");
				Thread.sleep(5000);
			} catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().getName() + " interrupted.");
				e.printStackTrace();
			}
		}
	}
}
