package customsorting;

import java.util.Comparator;

import student_dataBase_Management_System.Student;

public class SortStudentById implements Comparator<Student> {
	@Override
	public  int compare(Student x,Student y)
	{
		return x.getid().compareTo(y.getid()) ;
		
	}
}
