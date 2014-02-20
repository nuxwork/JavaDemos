package com.swordy.demo.java.lang.modifier;

public class Mouse extends Animal {
	protected Mouse() {
		System.out.println("a mouse bread.");
	}

	public Mouse(String name) {
		System.out.println("a new mouse '" + name + "' bread.");
		setName(name);
	}

	@Override
	public void cry() {
		super.cry();
		System.out.println("Mouse '" + getName() + "' cry...");
	}

	@Override
	protected void run() {
		System.out.println("Mouse '" + getName() + "' run...");
	}
	
	private class PrivateInnerMouse
	{
		
	}
	
	class DefaultInnerMouse
	{
		
	}
	
	protected class ProtectedInnerMouse
	{
		
	}
	
	public class PublicInnerMouse
	{
		
	}
	
	/*
	 * public static 已经不是内部类了
	 */
	public static class PublicStaticMouse
	{
		
	}
}
