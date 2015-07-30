package com.mikenhill.generics;

import java.util.ArrayList;
import java.util.List;

public class SuitInventory {

	private List<MensSuit> mensSuits = new ArrayList<MensSuit>();
	private List<WomensSuit> womensSuits = new ArrayList<WomensSuit>();

	public void getSuitsOverdueForInspection(List<? super Suit> overdueSuits) {
		getSuitsOverdueForInspectionFromList(mensSuits, overdueSuits);
		getSuitsOverdueForInspectionFromList(womensSuits, overdueSuits);
	}

	private void getSuitsOverdueForInspectionFromList(
			List<? extends Suit> suitList, List<? super Suit> overdueSuits) {
		for (Suit s : suitList)
			if (s.getOverdueForInspection())
				overdueSuits.add(s);
	}
}
