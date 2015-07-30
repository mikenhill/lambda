package com.mikenhill.lambda.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.util.stream.IntStream.generate;
import static java.util.stream.IntStream.rangeClosed;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.IntStream.generate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.mikenhill.lambda.objects.Human;

//Read with: http://www.baeldung.com/java-8-sort-lambda
public class CollectorTest {

	@Test
	public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
	    List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12));
	    Collections.sort(humans, new Comparator<Human>() {
	        @Override
	        public int compare(Human h1, Human h2) {
	            return h1.getName().compareTo(h2.getName());
	        }
	    });
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Jack", 12).getName()));
	    
	    Collection<Object> is = generate(() -> 0).limit(12).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	    System.out.println(is.size());
	    
	    final LocalDate january1st = LocalDate.now().withMonth(1).withDayOfMonth(1);
	    final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
	    String[] gg = rangeClosed(1, 12).mapToObj(i -> january1st.withMonth(i).format(dateTimeFormat)).toArray(size -> new String[3]);
	    //is2.mapToObj(i -> january1st.withMonth(i).format(dateTimeFormat)).toArray(size -> new String[3]);
	    
	}
	
	@Test
	public void whenSortingEntitiesByName_thenCorrectlySorted() {
	    List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12));
	    //Notice that we’re also using the new sort API added to java.util.List in Java 8
	    //– instead of the old Collections.sort API.
	    humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Jack", 12).getName()));
	    
	    //Can also be written as:
	    humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Jack", 12).getName()));
	    
	    //Can also be written as:
	    Comparator<Human> humanCompare = (Human h1, Human h2) -> h1.getName().compareTo(h2.getName()); 
	    humans.sort(humanCompare);
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Jack", 12).getName()));
	    
	}
	
	@Test
	public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
	    List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12), new Human("AJack", 12));
	     
	    humans.sort(Human::compareByNameThenAge);
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("AJack", 12).getName()));
	}
	
	
	@Test
	public void givenInstanceMethod_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
		List<Human> humans = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12));
	    //#4 
	    Collections.sort(humans, Comparator.comparing(Human::getName));
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Jack", 12).getName()));
	}
	
	@Test
	public void whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
	    List<Human> humans = Arrays.asList(
	      new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
	    //#5 
	    humans.sort((lhs, rhs) -> {
	        if (lhs.getName().equals(rhs.getName())) {
	            return lhs.getAge() - rhs.getAge();
	        } else {
	            return lhs.getName().compareTo(rhs.getName());
	        }
	    });
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Sarah", 10).getName()));
	}
	
	@Test
	public void givenComposition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
	    List<Human> humans = Arrays.asList(
	      new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12));
	    //#6
	    humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
	    Assert.assertThat(humans.get(0).getName(), equalTo(new Human("Sarah", 10).getName()));
	}
	
}
