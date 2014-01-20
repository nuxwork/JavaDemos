package com.swordy.demo.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.swordy.demo.java.annotation.Annotation1.Anno6.Size;

/**
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Annotation1
{
	private static final String TAG = "JavaDemos.Annotation1";

	public static void main(String[] args)
	{
		Mouse mouse = new Mouse();
		Field[] fields = mouse.getClass().getFields();
		for (Field f : fields)
		{
			Annotation[] annos = f.getAnnotations();

			if (annos == null || annos.length == 0)
			{
				System.out.println("Field: " + f.getName() + "\t no annotations.");
			}

			for (Annotation a : annos)
			{
				System.out.println(a.annotationType().getName());
			}
		}
		
		/*
		 * 由于此处的自定义Annotation没有添加@Retention属性，
		 * 因此，所有的Field的getAnnotations()都为空。
		 */
	}

	private static class Mouse
	{
		/*
		 * Annotation默认的关键字为value，可以不写。
		 */
		@Anno1("mouse_name")
		@Anno6(size = Size.SMALL)
		public String name;

		/*
		 * 非Value的key必须显示的写出来。
		 */
		@Anno2(key = "red")
		public String color;

		/*
		 * 支持多个key
		 */
		@Anno3(key = "mouse_age", value = 1)
		public String age;

		/*
		 * 可以是数组
		 */
		@Anno4({ "rice", "bread", "cheese" })
		public String foods;

		/*
		 * 带默认值的Annotation，不管关键字是否为value，都可以不写。
		 */
		@Anno5
		public void run()
		{

		}

		/*
		 * 还可以是枚举类型的
		 */
		@Anno6(size = Size.SMALL)
		public void size()
		{

		}
	}

	private static @interface Anno1
	{
		String value();
	}

	private static @interface Anno2
	{
		String key();
	}

	private static @interface Anno3
	{
		String key();

		int value();
	}

	private static @interface Anno4
	{
		String[] value();
	}

	private static @interface Anno5
	{
		String key() default "default";
	}

	static @interface Anno6
	{
		public static enum Size
		{
			BIG, NORMAL, SMALL
		}

		Size size() default Size.SMALL;
	}

}
