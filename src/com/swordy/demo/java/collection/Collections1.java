package com.swordy.demo.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections1
{
	private static final String TAG = "JavaDemos.Collections";

	public static void main(String[] args)
	{
		/*
		 * 对于已经实现了Comparator接口的类，可以直接使用Collections.sort()排序
		 * 对于没有实现Comparator接口的类，可以将临时的Comparator作为参数传给Collections.sort()
		 * 然后就可以进行排序了
		 */
		List<String> names = new ArrayList<String>();
		names.add("Oracal");
		names.add("Google");
		names.add("Apple");
		names.add("Microsoft");
		names.add("Yahoo");
		names.add("Samsung");
		System.out.println("\n排序前：");
		System.out.println(names);
		Collections.sort(names);
		System.out.println("\n排序后：");
		System.out.println(names);

		List<People> peoples = new ArrayList<People>();
		peoples.add(new People("lina"));
		peoples.add(new People("yangjian"));
		peoples.add(new People("lijun"));
		peoples.add(new People("dawei"));
		peoples.add(new People("erb"));
		System.out.println("\n排序前：");
		System.out.println(peoples);
		Collections.sort(peoples, new Comparator<People>() {

			@Override
			public int compare(People p1, People p2)
			{
				return p1.name.compareTo(p2.name);
			}
		});
		System.out.println("\n排序后：");
		System.out.println(peoples);
	}

	private static class People
	{
		public String name;

		public People(String name)
		{
			this.name = name;
		}
		
		@Override
		public String toString()
		{
			return name;
		}
	}
}
