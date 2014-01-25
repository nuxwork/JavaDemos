package com.swordy.demo.java.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1. JVM退出后，后台线程也跟着退出，后台线程的sleep、waite、IO等操作也会停止，
 * 但不会像interrupt那样触发异常。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Deamon2
{
	private static final String TAG = "JavaDemos.Deamon1";

	public static void main(String[] args)
	{
		Thread thr1 = new Thread() {
			@Override
			public void run()
			{
				int i = 0;
				while (true)
				{
					System.out.println(Thread.currentThread().getName() + " > running: " + i);
				}
			}
		};
		thr1.setDaemon(true);
		thr1.start();

		Thread thr2 = new Thread() {
			@Override
			public void run()
			{
				synchronized (this)
				{
					try
					{
						File file = new File("d:/out.txt");
						if (!file.exists())
						{
							file.createNewFile();
						}

						FileOutputStream fos = new FileOutputStream(file);

						int i = 0;
						while (i++ != 1000000000)
						{
							System.out.println("写文件...   >  " + i);
							fos.write(1);
							Thread.yield();
						}

						fos.close();
						System.out.println("文件写完了");
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		thr2.setDaemon(true);
		thr2.start();

		Thread thr3 = new Thread() {
			public void run()
			{
				try
				{
					System.out.println("我睡了 ----------");
					Thread.sleep(999);
				} catch (InterruptedException e)
				{
					System.out.println("还让不让睡了。");
					e.printStackTrace();
				}
			};
		};
		thr3.setDaemon(true);
		thr3.start();

		int i = 0;
		while (i++ != 10)
		{
			try
			{
				Thread.sleep(2);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("主线程退出 ####################");
	}
}
