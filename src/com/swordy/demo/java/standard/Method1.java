package com.swordy.demo.java.standard;

/**
 * 1. 在方法中直接使用成员变量是不安全的，必须使用临时变量保存成员变量。
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Method1
{
	private static final String TAG = "JavaDemos.Method1";

	public static void main(String[] args)
	{
		/*
		 * 在方法中直接使用成员变量的引用不安全，因为
		 * 在多线程中这个引用可能会指向一个新的对象，
		 * 即操作的对象在中途变为其他的对象。
		 */
		final Mouse mouse = new Mouse();
		new Thread() {
			@Override
			public void run()
			{
				mouse.setName("white");
				System.out.println(mouse);
			}
		}.start();

		new Thread() {
			@Override
			public void run()
			{
				mouse.setName(null);
			}
		}.start();

		/*
		 * 使用一个临时引用替代成员变量就能解决上述问题，
		 * 如果使用
		 */
		final Cat cat = new Cat();
		new Thread() {
			@Override
			public void run()
			{
				cat.setName("mimi");
				System.out.println(cat);
			}
		}.start();

		new Thread() {
			@Override
			public void run()
			{
				cat.setName(null);
			}
		}.start();
	}

	private static class Mouse
	{
		String name;

		public void setName(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			if (name != null)
			{
				try
				{
					Thread.sleep(1);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				return "Mosue:[name: " + name.toString() + "]";
			} else
			{
				return "Mouse:[name: unknow]";
			}
		}
	}

	private static class Cat
	{
		String name;

		public void setName(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			String str = name;
			if (str != null)
			{
				return "Cat:[name: " + str.toString() + "]";
			} else
			{
				return "Cat:[name: unknow]";
			}
		}
	}
}
