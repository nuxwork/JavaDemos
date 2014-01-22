package com.swordy.demo.java.thread;

/**
 * 1. 线程的运行状态可以通过isAlive()方法判断。
 * 2. join()方法为强制运行线程，并且只有在线程start()之后才起作用。
 * 3. 一旦强制运行线程，那么该线程直到运行结束后，其他线程都不会执行。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Thread2
{
	private static final String TAG = "JavaDemos.Thread2";

	public static void main(String[] args)
	{
		Mouse mouse = new Mouse("white ************** ");
		System.out.println("线程开始运行前  > isAlive: " + mouse.isAlive());
		mouse.start();
		System.out.println("线程开始运行后  > isAlive: " + mouse.isAlive());

		for (int i = 0; i++ != 50;)
		{
			if (i == 5)
			{
				try
				{
					/*
					 * mouse线程进行强制运行，强制运行期间，其他线程无法运行
					 * 即使mouse线程sleep、yield也不会终止，直到mouse线程运行完毕。
					 */
					mouse.join();

				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " run " + i);
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
			int i = 0;
			while (i++ != 30)
			{
				if (i == 15)
				{
					System.out.println("sleep一下....");
					try
					{
						Thread.sleep(10);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}

					System.out.println("yield一下....");
					Thread.yield();
				}
				System.out.println(Thread.currentThread().getName() + " run " + i);
			}
		}
	}
}
