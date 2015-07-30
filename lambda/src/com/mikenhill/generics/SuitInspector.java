package com.mikenhill.generics;

import java.util.ArrayList;
import java.util.List;

public class SuitInspector {
	private SuitInventory inventory = new SuitInventory();

	public void inspectSuits() {
		List<Suit> overdueSuits = new ArrayList<Suit>();
		inventory.getSuitsOverdueForInspection(overdueSuits);
		for (Suit overdueSuit : overdueSuits) {
			overdueSuit.inspect();
		}
	}
}
