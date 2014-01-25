package com.swordy.demo.java.thread;

/**
 * 1. 当对象在线程中被锁定时，其他线程访问此对象时，会先检查次对象是否加锁，
 * (1)如果加锁，则暂停执行，等待下次执行；
 * (2)如果未加锁，则加锁该对象，并执行后续的任务。
 * 2. 同步任务不是一直执行，而是根据线程分配到的时间片来执行，同样会和其他线程交替执行。
 * 
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 23, 2014
 * @version 1.0
 */
public class Lock1
{
	private static final String TAG = "JavaDemos.Lock1";

	static int count = 100;

	public static void main(String[] args)
	{

		/*
		 * 启动3个线程，其中第2个、第3个线程具有相同的同步对象。
		 */
		
		new Thread("&&&&&&&&&&") {
			public void run()
			{
				System.out.println(Thread.currentThread().getName() + ", hold...");
				while (count-- > 0)
				{
					System.out.println(Thread.currentThread().getName() + ", running 1 ...");
					try
					{
						sleep(2);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ", running 2 ...");
				}
			};
		}.start();

		final Object obj = new Object();

		new Thread("111111111") {
			public void run()
			{
				System.out.println(Thread.currentThread().getName() + ", hold...");
				synchronized (obj)
				{
					while (count-- > 0)
					{
						System.out.println(Thread.currentThread().getName() + ", ## running 1 ...");
						try
						{
							sleep(2);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ", ## running 2 ...");
					}
				}
			};
		}.start();

		new Thread("0000000000") {
			public void run()
			{
				System.out.println(Thread.currentThread().getName() + ", hold...");
				synchronized (obj)
				{
					while (count-- > 0)
					{
						System.out.println(Thread.currentThread().getName() + ", ~~ running 1 ...");
						try
						{
							sleep(2);
						} catch (InterruptedException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ", ~~ running 2 ...");
					}
				}
			};
		}.start();
	}
}
