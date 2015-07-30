package com.mikenhill.generics;

public class Animal {
	private int legCount;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal (String name, int legCount) {
		this.legCount = legCount;
		this.name = name;
	}
	
	public int getLegCount() {
		return legCount;
	}

	public void setLegCount(int legCount) {
		this.legCount = legCount;		
	}
	
}
