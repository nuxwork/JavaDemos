package com.swordy.demo.java.thread;

/**
 * 1. 父线程退出时，子线程会继续执行。
 * 2. 不能在线程运行时改变线程的deamon属性。
 * 3. 当进程中所有正在运行的线程都为deamon线程时，JVM会自动退出。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class MultiThread1
{
	private static final String TAG = "JavaDemos.MultiThread1";

	public static void main(String[] args)
	{
		new Thread("parent") {
			public void run()
			{
				Mouse white = new Mouse("white @@@@@@@@@");
				Mouse black = new Mouse("black ---------");

				/*
				 * 设置为后台线程，当所有正在运行的线程都为Daemon线程时,
				 * JVM会自动退出。
				 */
				white.setDaemon(true);
				black.setDaemon(true);

				white.setPriority(10);
				black.setPriority(9);

				white.start();
				black.start();

				int i = 0;
				while (i++ < 5)
				{
					System.out.println("parent run: " + i);
					Thread.yield();
				}
				System.out.println("parent exit.  ");
				
				/*
				 * 父线程退出后，子线程会继续执行。
				 */
			}
		}.start();
		
		int i = 0;
		while(i++ <40)
		{
			Thread.yield();
		}
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
			while (true)
			{
				System.out.println(Thread.currentThread().getName());
				/*
				 * 不能再运后改变此属性，否则会出发异常。
				 */
				// setDaemon(true);
				Thread.yield();
			}
		}
	}
}
