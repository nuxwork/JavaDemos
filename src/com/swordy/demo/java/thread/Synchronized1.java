package com.swordy.demo.java.thread;

/**
 * 同步方法的同步对象为this
 */
public class Synchronized1
{
	private static final String TAG = "JavaDemos.Synchronized1";

	public static void main(String[] args)
	{
		Lock l = new Lock();
		new Thread(l, "A").start();
		
		try
		{
			Thread.sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		l.b = false;
		
		new Thread(l, "B").start();
	}

	private static class Lock implements Runnable
	{
		private static int tickets = 100;

		private Object obj = new Object();

		boolean b = true;

		@Override
		public void run()
		{
			if (b)
			{
				while (tickets > 0)
				{
					synchronized (this)
					{
						if (tickets > 0)
						{
							System.out.println(Thread.currentThread().getName() + ", 同步对象this"
									+ ", ticket:  " + tickets--);
							try
							{
								Thread.sleep(2);
							} catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						}
					}
				}
			} else
			{
				while (tickets > 0)
				{
					sell();
				}
			}
		}

		/*
		 * sell的同步对象是this
		 */
		private synchronized void sell()
		{
			if (tickets > 0)
			{
				System.out.println(Thread.currentThread().getName() + ", 同步方法" + ", ticket:  "
						+ tickets--);
				try
				{
					Thread.sleep(2);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
