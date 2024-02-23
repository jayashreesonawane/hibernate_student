package hibernate_student.controller;

import java.util.Scanner;

import hibernate_student.dao.StudentDao;
import hibernate_student.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		
		//System.out.println("Enter the choice : \n1.Save Student \n2. Find Student by Id \n3. Get Student by Phone \n4.Get Student by Email \n5.Update Student \n6.Delete Student \n7. Find Student");
		
		System.out.println("Enter your choice : \n1.Save Student \n2.Get Student by ID \n3.Update Student \n4.Delete Student \n5.Get All Students \n6.Get Student by Phone \n7.Get Student by Email");
		
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
		{
			System.out.println("Enter Id : ");
			int id = scanner.nextInt();
			System.out.println("Enter Name : ");
			String name = scanner.next();
			System.out.println("Enter Marks : ");
			int marks = scanner.nextInt();
			System.out.println("Enter Phone : ");
			long phone = scanner.nextLong();
			System.out.println("Enter Address : ");
			String address = scanner.next();
			System.out.println("Enter email : ");
			String email = scanner.next();
			
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setPhone(phone);
			student.setAddress(address);
			student.setEmail(email);
			
			studentDao.saveStudent(student);
			System.out.println("Student Data Saved Successfully!");
		}
			break;

		case 2 :
		{
			System.out.println("Enter the id of student you want to find : ");
			int id = scanner.nextInt();
			
			studentDao.fetchStudent(id);
		}
		
			break;
			
		case 3 :
		{
			System.out.println("Enter Id : ");
			int id = scanner.nextInt();
			System.out.println("Enter Name : ");
			String name = scanner.next();
			System.out.println("Enter Marks : ");
			int marks = scanner.nextInt();
			System.out.println("Enter Phone : ");
			long phone = scanner.nextLong();
			System.out.println("Enter Address : ");
			String address = scanner.next();
			System.out.println("Enter email : ");
			String email = scanner.next();
			
			student.setId(id);
			student.setName(name);
			student.setMarks(marks);
			student.setPhone(phone);
			student.setAddress(address);
			student.setEmail(email);
			
			studentDao.updateStudent(student);
			System.out.println("Student Data Updated Successfully!");
		}
			
			break;
			
		case 4 :
		{
			System.out.println("Enter the id of student you want to delete : ");
			int id = scanner.nextInt();
			
			studentDao.deleteStudent(id);
			System.out.println("Student Data Deleted Successfully");
		}
			
			break;
			
		case 5 :
		{
			studentDao.getAllStudents();
		}
			break;
			
		case 6 :
		{
			System.out.println("Enter phone number : ");
			long phone = scanner.nextLong();
			
			studentDao.getStudent(phone);
		}
			break;
			
		case 7 :
		{
			System.out.println("Enter email : ");
			String email = scanner.next();
			
			studentDao.getStudent(email);
		}
			break;
			
		default:
			break;
		}
		
		

	}
}
