package com.spring.hibernate.cruddemo;

import com.spring.hibernate.cruddemo.dao.StudentDAO;
import com.spring.hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	};
	}

	private void createMultiStudent(StudentDAO studentDAO) {

		//create 3 student objects
		System.out.println("Creating 3 new student object ...");
		Student tempStudent1 =new Student("Paul","Doe", "paul@gmail.com");
		Student tempStudent2 =new Student("Maul","Doe", "maul@gmail.com");
		Student tempStudent3 =new Student("Kaul","Doe", "kaul@gmail.com");

		//save student objects
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

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



	}

}
















