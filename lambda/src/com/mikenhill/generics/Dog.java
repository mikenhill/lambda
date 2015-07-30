package com.mikenhill.generics;

public class Dog extends Animal {
	private int paws;
	
	public Dog (String name) {
		super(name, 4);
		this.paws = 4;
		
	}
	
	public int getPaws() {
		return paws;
	}

	public void setPaws(int paws) {
		this.paws = paws;
	}
	
}
