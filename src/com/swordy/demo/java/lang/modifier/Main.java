package com.swordy.demo.java.lang.modifier;

public class Main {
	public static void main(String[] args) {
		/*
		 * 同一包下可以访问protected成员
		 */
		Mouse m = new Mouse();
		m.setName("jiji");
		m.cry();
		m.run();

		System.out.println();

		/*
		 * 同一包下可以访问'default'成员
		 */
		Cat c = Animal.bread(Cat.class);
		c.setName("mimi");
		c.cry();
		c.run();

		// ! Mouse.PrivateInnerMouse mm0;
		Mouse.DefaultInnerMouse mm1 = null;
		//! mm1 = new Mouse.DefaultInnerMouse();
		Mouse.ProtectedInnerMouse mm2 = null;
		//! mm2 = new Mouse.ProtectedInnerMouse();
		Mouse.PublicInnerMouse mm3 = null;
		//! mm3 = new Mouse.PublicInnerMouse();
		Mouse.PublicStaticMouse mm4 = null;
		mm4 = new Mouse.PublicStaticMouse();
	}
}
