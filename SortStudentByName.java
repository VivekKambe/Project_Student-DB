package customsorting;

import java.util.Comparator;

import student_dataBase_Management_System.Student;

public class SortStudentByName implements Comparator<Student> {
	@Override
	public  int compare(Student x,Student y)
	{
		return x.getName().compareTo(y.getName());
		

}}
