package com.mikenhill.generics;

public class Chimp extends Animal {
	private int arms;

	public Chimp (String name) {
		super(name, 2);
		this.arms = 2;
	}
	
	public int getArms() {
		return arms;
	}

	public void setArms(int arms) {
		this.arms = arms;
	}
	
}
