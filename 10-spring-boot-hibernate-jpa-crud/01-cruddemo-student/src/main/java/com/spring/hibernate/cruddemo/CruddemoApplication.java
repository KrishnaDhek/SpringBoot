package com.spring.hibernate.cruddemo;

import com.spring.hibernate.cruddemo.dao.StudentDAO;
import com.spring.hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean

	// CommandLineRunner bean to execute code when the application starts
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
	return runner->{

//		createStudent(studentDAO);
		createMultiStudent(studentDAO);
//		readStudent(studentDAO);
//		queryForStudent(studentDAO);
//		queryForStudentByLastName(studentDAO);
//		updateStudent(studentDAO);
//		deleteStudent(studentDAO);
//		deleteAllStudent(studentDAO);
	};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted :" +numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//retrieving student based on the id: primary key
		int studentId =3;
		System.out.println("Deleting student with id :" +studentId);

		//deleting the student
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve students based on id: primary key
		int studentID =2;
		System.out.println("Getting student with id:" +studentID);
		Student myStudent = studentDAO.findById(studentID);

		//change first name to "Maul"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Maul");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student :"+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		//get a list of student
		List<Student> theStudent = studentDAO.findByLastName("Pam");

		//display the list of student
		for (Student tempStud : theStudent){
			System.out.println(tempStud);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {

		//get a list of students

		List<Student> theStudent = studentDAO.findAll();

		//display the list of students
		for (Student student: theStudent){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Create a new student");
		Student tempStudent = new Student("Kim", "Zen", "kim@gmail.com");

		//save the object
		System.out.println("Save the student");
		studentDAO.save(tempStudent);

		//display id of saved student
		int theID = tempStudent.getId();
		System.out.println("Saved Student. Generated ID :" +theID);

		//retrieve student based on the id:primary key
		System.out.println("Retrieving student with id :"+ theID);
		Student myStudent = studentDAO.findById(theID);

		//display student
		System.out.println("Found the student :"+myStudent);


	}

	private void createMultiStudent(StudentDAO studentDAO) {

		//create 3 student objects
		System.out.println("Creating 5 new student object ...");
		Student tempStudent1 =new Student("Paul","Doe", "paul@gmail.com");
		Student tempStudent2 =new Student("Maul","Doe", "maul@gmail.com");
		Student tempStudent3 =new Student("Kaul","Doe", "kaul@gmail.com");
		Student tempStudent4 =new Student("Alex","Pam", "kaul@gmail.com");
		Student tempStudent5 =new Student("Haley","Pam", "kaul@gmail.com");



		//save student objects
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);

	}

	private void createStudent(StudentDAO studentDAO) {


		//create the student object
		System.out.println("Creating a new student object ...");
		Student tempStudent =new Student("Paul","Doe", "paul@gmail.com");



		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);



		//display the id of the saved student
		System.out.println("Save student. Generated id: "+tempStudent.getId());

		//retrieve student by id



	}

}
















