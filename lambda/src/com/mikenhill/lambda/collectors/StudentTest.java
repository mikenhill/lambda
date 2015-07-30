package com.mikenhill.lambda.collectors;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

import ac.simons.biking2.persistence.entities.Bike;

public class StudentTest {

	@Test
	public void studentTest() {
		
		List<Student> lStudent = Arrays.asList(new Student("stu01", "class2", 23), new Student("stu02", "class1", 24));
		
		Map<String, List<Student>> stdByClass = lStudent.stream()
                .collect(Collectors.groupingBy(Student::getClassName));
		
		stdByClass.forEach((k, v) -> System.out.println(k + " = " + v.size()));
	}
	
	
	public static void summarizePeriods(final List<Student> students) {
		
		FunctionalInterface fi = Map.Entry::getKey;
		
		Collectors.reducing(0, Map.Entry::getKey, Integer::sum);
	    }    
	
}
