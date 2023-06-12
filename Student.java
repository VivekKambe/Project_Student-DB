package student_dataBase_Management_System;

public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
	
	static int count=101;
	public Student(int age,String name,int marks)
	{
		this.id="JSP"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
		
	}
	public String getid()
	{
		return id;
	}
	public int getAge()
	{
		return age;
	}
	public String getName()
	{
		return name;
	}
	public int getMarks()
	{
		return marks;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setMarks(int marks)
	{
		this.marks=marks;
	}
	
public String toString()
{
	return "ID : "+id+" Age :"+age+" Name :"+name+" Marks : "+marks;
}

}
