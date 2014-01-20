package com.swordy.demo.java.thread;

/**
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 19, 2014
 * @version 1.0
 */
public class SellTickets1
{
	private static final String TAG = "JavaDemos.SellTickets1";

	public static void main(String[] args)
	{
		TicketsSeller ts = new TicketsSeller();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
	}

	private static class TicketsSeller implements Runnable
	{
		private int tickets = 40;
		private Object obj = new Object();

		@Override
		public void run()
		{
			while (true)
			{
				/*
				 * 每个对象都有一个监视器monitor，即锁，每次执行到这里， 会先判断obj是否加锁，如果没有则加锁。
				 */
				System.out.println(Thread.currentThread().getName() + " # ");

				synchronized (obj)
				{
					if (tickets > 0)
					{
						try
						{
							/*
							 * 只要加了锁，即使sleep也不会中断执行。
							 */
							Thread.sleep(2);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ", sell ticket: "
								+ tickets);
						tickets--;
					} else
					{
						break;
					}
				}

				/*
				 * 这里暂停一下，使下一个线程开始执行。
				 */
				try
				{
					Thread.sleep(8);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
