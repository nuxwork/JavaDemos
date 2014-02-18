package com.swordy.demo.java.lang.init;

public class Cat {
	private Mouse mouse1 = new Mouse("private mouse-1");;

	static Mouse mouse2 = new Mouse("static mouse-2");;

	Mouse mouse3 = new Mouse("default mouse-2");;
	
	static{
		Mouse mouse5 = new Mouse("static block mouse-5");
	}

	public String name;

	public Cat(String name) {
		this.name = name;
	}

	static Mouse mouse4 = new Mouse("static mouse-4");
}
