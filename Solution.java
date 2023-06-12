package student_dataBase_Management_System;


import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Wellcome to Student Database System");
		System.out.println("<--------------------------------->");
		Scanner sc=new Scanner(System.in);
		
		StudentManagementSystem sms=new SMSimpl();
		while(true)
		{
			System.out.println("1:addStudent\n2:displayStudent\n3:displayAllStudents\n4:removeStudent\n5:removeAllStudents");
			System.out.println("6:updateStudent\n7:countStudents\n8:sortStudents\n9:getStudentWithHighestMarks");
			System.out.println("10:getStudentWithLowestMarks\n11:Exit");
			System.out.println("enter choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
				
			case 2:
				sms.displayStudent();
				break;
				
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
				
			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
				
			case 7:
				sms.countStudents();
				break;
				
			case 8:
				sms.sortStudents();
				break;
				
			case 9:
				sms.getStudentWithHighestMarks();
				break;
					
			case 10:
				sms.getStudentWithLowestMarks();
				break;
				
			case 11:
				System.out.println("Exit");
				
			default :
				try
				{
					throw new InvalidChoiceException("invalid choice");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				System.out.println("****************\n****************");
			}
		
		}
		
	}
	
}
