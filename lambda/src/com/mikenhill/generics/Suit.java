package com.mikenhill.generics;

public class Suit {
	protected boolean overdueForInspection = false;
	
	public void inspect() {
		
	}
	
	public boolean getOverdueForInspection() {
		return overdueForInspection;
	}

	public void setOverdueForInspection(boolean overdueForInspection) {
		this.overdueForInspection = overdueForInspection;
	}
}
