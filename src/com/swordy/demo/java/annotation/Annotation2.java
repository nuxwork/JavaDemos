package com.swordy.demo.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 21, 2014
 * @version 1.0
 */
public class Annotation2
{
	private static final String TAG = "JavaDemos.Annotation2";

	public static void main(String[] args)
	{
		Mouse mouse = new Mouse();

		Field[] fields = mouse.getClass().getFields();
		for (Field f : fields)
		{
			Annotation[] annos = f.getAnnotations();
			for (Annotation a : annos)
			{
				String str = "Field: \"" + f.getName() + "\"";
				if (a != null)
				{
					if (a instanceof Mapping)
					{
						str += ", mapping: \"" + ((Mapping) a).value() + "\"";
					} else if (a instanceof Convert)
					{
						str += ", convert: \"" + ((Convert) a).value() + "\"";
					}
				} else
				{
					str += " annotation is null.";
				}
				System.out.println(str);
			}
		}
		
		/*
		 * 三个属性，只打印出两个，即Retention为RUNTIME的Mapping，
		 * Retention为SOURCE的，在运行时为null。
		 */
	}

	private static class Mouse
	{
		/*
		 * Mapping的保存范围为RUNTIME，
		 * 在运行时为该Annotation不为null。
		 */
		@Mapping("mouse_name")
		public String name;

		@Mapping("mouse_color")
		public int color;

		/*
		 * Convert的保存范围为SOURCE，
		 * 在运行时为该Annotation为null。
		 */
		@Convert("mouse_weight")
		public float weight;
	}

	// Mapping的保存范围为RUNTIME
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	private static @interface Mapping
	{
		String value();
	}

	// Convert的保存范围为SOURCE
	@Retention(RetentionPolicy.SOURCE)
	@Target(ElementType.FIELD)
	private static @interface Convert
	{
		String value();
	}
}
