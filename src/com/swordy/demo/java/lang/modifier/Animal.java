package com.swordy.demo.java.lang.modifier;

public class Animal {
	public interface OnCryListener {
		void onCry();
	}

	private String name;

	private OnCryListener cryListener;

	protected Animal() {
		System.out.println("a new animal bread.");
	}

	public Animal(String name) {
		System.out.println("a new animal '" + name + "' bread.");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OnCryListener getCryListener() {
		return cryListener;
	}

	public void setCryListener(OnCryListener cryListener) {
		this.cryListener = cryListener;
	}

	public void cry() {
		onCry();
	}

	private void onCry() {
		if (cryListener != null) {
			cryListener.onCry();
		} else {
			System.out.println("animal cry...");
		}
	}

	protected void run() {
		System.out.println("animal run...");
	}

	static <T extends Animal> T bread(Class<? extends Animal> cls) {
		try {
			return (T) cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public class Life
	{
		
	}
}
