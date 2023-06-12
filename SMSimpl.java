package student_dataBase_Management_System;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.studentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class SMSimpl implements StudentManagementSystem {

	Scanner sc =new Scanner(System.in);

	Map<String,Student>db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent() {
		System.out.println("Enter student Age");
		int age=sc.nextInt();
		System.out.println("Enter student Name");
		String name =sc.next();
		System.out.println("Enter student marks");
		int marks=sc.nextInt();

		Student std=new Student(age,name,marks);
		db.put(std.getid(),std);
		System.out.println("Student record inserted succussfully");
		System.out.println("student id is = "+std.getid());
	}
	@Override
	public void displayStudent() {

		System.out.println("enter student id");
		String id=sc.next();  //String id=scan.next().toUpperCase();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("students details are as fallows");
			System.out.println("Student id "+std.getid());
			System.out.println("Student Age "+std.getAge());
			System.out.println("Student Name "+std.getName());
			System.out.println("Student Marks "+std.getMarks());
		}
		else
		{
			try {
				String msg="Student with the Id "+id+" is not Found";
				throw new studentNotFoundException(msg);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() {

		System.out.println("Student details as fallows");
		System.out.println("--------------------------");
		Set<String>keys=db.keySet();
		if(db.size()!=0)
		{
			for(String key:keys)
			{
				System.out.println(db.get(key));
				//			        	 Student std=db.get(key);               
				//			             System.out.println(std);
			}
		}
		else
		{
			try {
				String msg="Student data base is empty nothing to display";
				throw new studentNotFoundException(msg);
			}
			catch(studentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}  
		}

	}

	@Override
	public void removeStudent() {
		System.out.println("enter Student id");
		String id=sc.next().toUpperCase();		
		if(db.containsKey(id))
		{
			System.out.println("Student record found");
			System.out.println(db.get(id));// getting and printing the student object
			db.remove(id);// remove the student object
			System.out.println("Student Record Deleted Successfully");

		}
		else
		{
			try {
				String msg="Student Not found Exception";
				throw new studentNotFoundException(msg);
			}
			catch(studentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllStudents() {
		if(db.size()!=0)
		{
			System.out.println("Availabel Student records :"+db.size());
			db.clear();
			System.out.println("All the Student record is deleted Successfully");
		}
		else{
			try {
				String msg="Student data base is empty nothing to remove";
				throw new studentNotFoundException(msg);
			}
			catch(studentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}  
		}
	}
	@Override
	public void updateStudent() {
		System.out.println("Enter a student id");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println("1:Update Age \n2:Update Name\n3:Update Marks");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter a age");
				//				 int age=sc.nextInt();
				//				 std.setAge(age);
				std.setAge(sc.nextInt());
				System.out.println("Age updated successfully");
				break;
			case 2:
				System.out.println("Enter a Name");
				std.setName(sc.next());
				System.out.println("Name updated successfully");
				break;
			case 3:
				System.out.println("Enter a Marks");
				std.setMarks(sc.nextInt());
				System.out.println("Marks updated successfully");
				break;
			default :
				try
				{
					throw new InvalidChoiceException("invalid choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else{
			try {
				String msg="Student "+id+" is not Found";
				throw new studentNotFoundException(msg);
			}
			catch(studentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}  
		}
	}

	@Override
	public void countStudents() {

		System.out.println("number of Student Record :"+db.size());

	}

	@Override
	public void sortStudents() {

		if(db.size()>=2) {
			List<Student>list=new ArrayList<Student>();
			Set<String>keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			System.out.println("1: sort Student By id\n2: sort Student By Age\n3: sort Student By Name\n4: sort Student By Marks");
			System.out.println("Enter choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				Collections.sort(list,new SortStudentById());
				display(list);
				break;
			case 2:
				Collections.sort(list,new SortStudentByAge());
				display(list);
				break;

			case 3:
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			case 4:
				Collections.sort(list,new SortStudentByMarks());
				display(list);
				break;
			default:
				try
				{
					String message= "Invalid choice, Enter a valid choice ";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

			}
		}
		else
			try {
				String message="No sufficient record to sort";
				throw new studentNotFoundException(message);
			}
		catch(Exception e){
			System.out.println(e.getMessage());

		}

	}
	private static  void display(List<Student> list)
	{
		for(Student s:list)
		{
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
			List<Student>list=new ArrayList<Student>();
			Set<String>keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(list.size()-1));

		}
		else
		{
			try {
				String message="No sufficient record to compare";
				throw new studentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());

			}
		}


	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
			List<Student>list=new ArrayList<Student>();
			Set<String>keys=db.keySet();
			for(String key:keys)
			{
				list.add(db.get(key));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));

		}
		else
		{
			try {
				String message="No sufficient record to compare";
				throw new studentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());

			}
		}


	}

}
