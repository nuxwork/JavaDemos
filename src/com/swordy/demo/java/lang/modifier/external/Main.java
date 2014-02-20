package com.swordy.demo.java.lang.modifier.external;

import com.swordy.demo.java.lang.modifier.Animal;
import com.swordy.demo.java.lang.modifier.Mouse;

/*
 * 类的访问权限
 * 1. public 可以任何地方访问
 * 2. protected 能在子类、包内访问
 * 3. default 包内可访问
 * 4. private 不可访问
 * 
 * 内部类的访问权限
 * 1. public static 可以在任何地方访问并实例化
 * 2. public 可以在任何地方访问但不能实例化
 * ...
 * 
 * public内部类不能实例化，但public接口能实例化是因为
 * 接口的实现就在本地。
 */
public class Main {
	public static void main(String[] args) {
		/*
		 * 不同包，下能访问protected成员
		 */
		//! Mouse m = new Mouse();
		
		
		/*
		 * 不同包，不能访问'default'成员
		 */
		//! Cat c = Animal.bread(Cat.class);
		
		/*
		 * 不同包下只能访问public成员
		 */
		Mouse mouse = new Mouse("jiji");
		
		//! mouse.run();
		
		mouse.cry();
		
		/*
		 * public 的interface可以访问
		 */
		mouse.setCryListener(new Animal.OnCryListener() {
			
			@Override
			public void onCry() {
				System.out.println("jiji cry...");
			}
		});
		mouse.cry();
		
		/*
		 * public 的inner class不能实例化
		 */
		Animal.Life life = null;
		// ! Animal.Life life1 = new Animal.Life();
		// ! Animal.Life life2 = animalLife.new Animal.Life();
		Animal animalLife = new Animal("for life");
		
		/*
		 * public 的 inner interface 能实例化，是因为接口是在本地实现的
		 * 即，所以可以访问
		 * 
		 */
		Animal.OnCryListener l = new Animal.OnCryListener() {
			
			@Override
			public void onCry() {
				
			}
		};
		
		/*
		 * 内部类的访问权限
		 */
		//! Mouse.PrivateInnerMouse mm0;
		//! Mouse.DefaultInnerMouse mm1;
		//! Mouse.ProtectedInnerMouse mm2;
		Mouse.PublicInnerMouse mm3;
		Mouse.PublicStaticMouse mm4;
	}
}
