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
		createInstructor(appDAO);

		};
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
