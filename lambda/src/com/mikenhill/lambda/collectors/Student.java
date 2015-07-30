package com.mikenhill.lambda.collectors;

public class Student {
    private String name;
    private int age;
    private String className;
    public boolean hasMilages() {
    	return true;
    }
    
    public Student(String name,String className,int age){
        this.name=name;
        this.age=age;
        this.className = className;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getClassName() {
        return className;
    }
} 