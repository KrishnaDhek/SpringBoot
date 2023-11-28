package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.AppDAO;
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
				findInstructorDetail(appDAO);

		};
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
		int theId =2;

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
		Instructor tempInstructor = new Instructor("Mohit","Dhek","mohit@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.night.com","guitar");

		//association
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving the instructor:"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");



	}

}
