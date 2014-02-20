package com.swordy.demo.java.lang.extend;

public class Animal {

	private String name;

	private int age;
	
	protected Animal() {
		System.out.println("new animal without name");
	}
	
	protected Animal(int age)
	{
		System.out.println("new animal was " + age + " years old.");
		this.age = age;
	}

	protected Animal(String name) {
		System.out.println("new animal named " + name);
		this.name = name;
	}
	
	protected Animal(String name, int age)
	{
		System.out.println("new animal named " + name + " and " + age + " years old");
		this.name = name;
		this.age = age;
	}

	public void cry() {
		System.out.println("animal " + name + " crying...");
	}
}
