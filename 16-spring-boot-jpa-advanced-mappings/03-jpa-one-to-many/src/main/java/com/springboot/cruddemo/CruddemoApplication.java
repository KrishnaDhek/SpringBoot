package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.AppDAO;
import com.springboot.cruddemo.entity.Course;
import com.springboot.cruddemo.entity.Instructor;
import com.springboot.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner->{

			//	createInstructor(appDAO);
			//	findInstructor(appDAO);
			//	deleteInstructor(appDAO);
			//	findInstructorDetail(appDAO);
			//	deleteInstructorDetail(appDAO);

			createInstructorWithCources(appDAO);

		};
	}

	private void createInstructorWithCources(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Jim","Den","jim@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com","dance");

		//association
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse = new Course("Air Guitar- The Ultimate Guide");
		Course tempCourse1 = new Course("Cooking Masterclass");
		Course tempCourse2 = new Course("Coding Masterclass");

		//add courses to instructor
		//this will AUTO save to the courses
		//because of cascading PERSIST
		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		System.out.println("Saving Instructor "+tempInstructor);

		System.out.println("The Courses :"+ tempInstructor.getCourses());

		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId= 5;
		System.out.println("Deleting instructor detail id:" +theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		//get the instructor detail object
		int theId=1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print the instructor detail
		System.out.println("Instructor detail :"+tempInstructorDetail);

		//print he associated instructor
		System.out.println("Associated instructor:" +tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId =6;

		System.out.println("Delete instructor id:" +theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId =3;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor id :"+theId);
		System.out.println("instructor is :" +tempInstructor);
		System.out.println("the associated details are :"+tempInstructor.getInstructorDetail());
	}


	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Monika","Dhek","monika@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.giggle.com","home decor");

		//association
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving the instructor:"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");



	}

}
