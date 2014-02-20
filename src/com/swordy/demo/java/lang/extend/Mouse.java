package com.swordy.demo.java.lang.extend;

public class Mouse extends Animal {
	private String name;
	private int age;

	public Mouse() {
		super();
		// super("lili"); 只能初始化一次
		System.out.println("new mouse without name");
	}

	public Mouse(String name) {
		this.name = name;
		System.out.println("new mouse named " + name);
	}

	public Mouse(int age) {
		this.age = age;
		System.out.println("new mouse was " + age + " years old.");
	}

	public Mouse(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("new mouse named " + name + " was " + age + " years old.");
	}  

	public void cry() {
		System.out.println("mouse " + name + " cry...");
	}

	public void callSuper() {
		super.cry();
	}
}
