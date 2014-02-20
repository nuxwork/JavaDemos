package com.swordy.demo.java.lang.modifier;

public class Cat extends Animal{
	protected Cat()
	{
		System.out.println("a cat bread.");
	}
	

	public Cat(String name) {
		System.out.println("a new cat '" + name + "' bread.");
		setName(name);
	}

	@Override
	public void cry() {
		super.cry();
		System.out.println("Cat '"+getName()+"' cry...");
	}

	@Override
	protected void run() {
		System.out.println("Cat '"+getName()+"' run...");
	}

}
