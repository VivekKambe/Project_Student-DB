package com;

public class Employee {
	String id;
	String name;
	static int count=101;
	public Employee(String name)
	
	{
		this.id="JSP"+count;
		this.name=name;
		count++;
	}
	public String toString()
	{
		return "id "+id+" Name  "+name;
	}

	public static void main(String[] args) {
		
		Employee e1=new Employee("tom");
		System.out.println(e1);
		Employee e2=new Employee("jerry");
		System.out.println(e2);

	}

}
