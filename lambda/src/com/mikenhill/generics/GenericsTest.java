package com.mikenhill.generics;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mikenhill.lambda.objects.Human;

public class GenericsTest {

	@Test
	public void test_GenericsExtends() {
	    
		List<Dog> lDogs = Arrays.asList(new Dog("fido"), new Dog("shep"));
		Assert.assertThat(lDogs.size(), equalTo(listCount(lDogs)));
		
		List<Dog> lDogs2 = Arrays.asList(new Dog("fido"), new Dog("shep"));
		Assert.assertThat(lDogs2.size(), equalTo(listCount2(lDogs2)));		
	    
	}
	
	private int listCount (List<? extends Animal> theList) {
		int listCount = 0;
		
		for (Animal animal : theList) {
			if (animal instanceof Dog) {
				listCount ++;
			}
			//Not allowed as may be a Chimp
			//Dog myDog = theList.get(0);
		}
		
		return listCount;
	}
	
	private int listCount2 (List<? super Dog> theList) {
		int listCount = 0;
		
		for (Object sDog : theList) {
			if (sDog instanceof Dog) {
				listCount ++;
			}
			//Not allowed as may be a Chimp
			theList.add(new SmallDog("rex", 33));
		}
		
		return listCount;
	}
	
}
