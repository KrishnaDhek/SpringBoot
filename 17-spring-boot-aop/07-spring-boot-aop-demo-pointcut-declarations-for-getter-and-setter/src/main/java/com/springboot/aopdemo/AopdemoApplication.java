package com.springboot.aopdemo;

import com.springboot.aopdemo.dao.AccountDAO;
import com.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	// CommandLineRunner bean to execute code when the Spring application starts
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return  runner -> {
			// Demo the @Before advice method
			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
		};
	}


	// Method to demonstrate calling business methods and applying @Before advice
	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// Call the business method in AccountDAO
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// Call the business method in MembershipDAO
		theMembershipDAO.addSillyAccount();
		theMembershipDAO.goToSleep();

	}
}
