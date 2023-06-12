package customsorting;

import java.util.Comparator;

import student_dataBase_Management_System.Student;

public class SortStudentByAge implements Comparator<Student> {
	@Override
	public  int compare(Student x,Student y)
	{
		return x.getAge()-y.getAge();
		

}}
