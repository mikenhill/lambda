package com.mikenhill.lambda.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ReducingDemo {
	public static void main(String[] args) {
		Student s1 = new Student("Shyam", "A", 21);
		Student s2 = new Student("Ram", "A", 23);
		Student s3 = new Student("Mohan", "B", 25);
		Student s4 = new Student(null, "B", 26);
		List<Student> list = Arrays.asList(s1, s2, s3, s4);
		
		Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);
		
		Map<String, Optional<Student>> eldestByClass = 
				list.stream().collect(
						Collectors.groupingBy(Student::getClassName, 
						Collectors.reducing(BinaryOperator.maxBy(ageComparator))));
		
		eldestByClass.forEach((k, v) -> 
				System.out.println("Class:" 
						+ k
						+ " Age:" + ((Optional<Student>) v).get().getAge() + " Name:"
						+ ((Optional<Student>) v).get().getName()));
	}
}
